package is.ru.tictactoe;

/**
* The Tic Tac Toe program implements well known board game where two opponents are playing against each other
* One player has 'x' symbol and the other 'o' symbol. They take turns and the one who manages to create line of three same symbols wins
* @param COMPUTER is a boolean variable that holds information whether the player is a computer; set as default to false
* @param HUMAN is a boolean variable that holds information whether the player is a human; set as default to true
* @param PLAYER1 is a boolean variable that assignes the Player1; set as default to true
* @param PLAYER2 is a boolean variable that assignes the Player2; set as default to false
* @param ui creates a new instance of consoleUI
* @param save saves to file scores of the game
* @param board creates a new instance of the board
* @param player1 creates a new instance of player
* @param player2 creates a new instance of player
*/
public class TicTacToe {

	private final boolean COMPUTER = false;
	private final boolean HUMAN = true;
	private final boolean PLAYER1 = true;
	private final boolean PLAYER2 = false;

	private ConsoleUI ui;
	private SaveToFile save;
	private Board board;
	private Player player1;
	private Player player2;

	/**
	 * Creates a new instance of a TicTacToe game.
	 * Players will be named "Player 1" and "Player 2" by default, Player 2 will be human
	 * and the board will be empty.
	 */
	public TicTacToe() {
		player1 = new Player("Player 1", true);
		player2 = new Player("Player 2", false);
		board = new Board();
		save = new SaveToFile();
		ui = new ConsoleUI();
	}

	/**
	* This method implements the gameplay. Player1 takes turn and then Player2
	* @param firstPlayer is the player that starts the game. At the beginning of the game this variable is set to PLAYER1
	* @param currentPlayer is the player that has her/his turn to move. At the beginning of the game this variable is set to player1
	* @param comp is a computerAI player
	* @param winner is the player that has won the game
	*/

	private void play(boolean opponent) {
		boolean firstPlayer = PLAYER1;

		do {
			resetBoard();
			boolean currentPlayer = firstPlayer;
			ui.draw();

			while(getWinner() == null && !isFull()) {
				ui.draw(board);
				ui.displayTurn(getPlayer(currentPlayer));

				if(opponent == HUMAN) {
					while(!makeMove(ui.getMove(), currentPlayer)) {
						ui.promptIllegalMove();
					}
				}
				else {
					ComputerPlayer comp = (ComputerPlayer)player2;
					int move = comp.generateMove(getBoard());
					if(makeMove(move, false)) {
						System.out.println("Computer made a move");
					}
					else {
						System.out.println("Computer tried to make an illegal move");
					}
				}
				currentPlayer = !currentPlayer;
			}

			Player winner = getWinner();

			if(winner != null) {
				winner.raiseScore();
			}

			// If winner is null, UI will report a tie
			ui.display(winner);
			ui.displayScore(player1, player2);
			// Swap the player that takes the first turn each round.
			firstPlayer = !firstPlayer;
		} while(ui.promptContinue());
	}

	/**
	 * Runs the Tic Tac Toe game with default settings
	 */
	public void run() {

		ui.displayWelcome();

		String userInput;
		do {
			userInput = ui.displayPrompt();
			String[] tokens = userInput.split(" ");

			if(userInput.toLowerCase().startsWith("play")) {
				if(tokens.length > 1) {
					if(tokens[1].toLowerCase().equals("computer")) {
						System.out.println("Sorry, not implemented yet!");
						//play(COMPUTER);
					}
					else if(tokens[1].toLowerCase().equals("human")) {
						play(HUMAN);
					}
					else {
						ui.invalidArgument(tokens[1]);
					}
				}
				// Default for no arguments is to play a human
				else {
					play(HUMAN);
				}
			}

			else if(userInput.toLowerCase().equals("score")) {
					ui.displayScore(player1, player2);
			}

			else if(userInput.toLowerCase().startsWith("setname")) {
				if(tokens.length > 2) {
					if(tokens[1].toLowerCase().equals("player1")) {
						String oldname = getPlayer(true).getName();
						changePlayerName(tokens[2], true);
						ui.confirmNameChange(tokens[2], oldname);
					}
					else if(tokens[1].toLowerCase().equals("player2")) {
						String oldname = getPlayer(false).getName();
						changePlayerName(tokens[2], false);
						ui.confirmNameChange(tokens[2], oldname);
					}
					else {
						ui.invalidArgument(tokens[1]);
					}
				}
				else {
					ui.invalidArgument();
				}
			}

			else if(userInput.toLowerCase().equals("reset")) {
				if(ui.confirmAction(userInput.toLowerCase())) {
					player1.setName("Player 1");
					player2.setName("Player 2");
					player1.resetScore();
					player2.resetScore();
					board.reset();
					ui.displayReset();
				}
			}

			else if(userInput.toLowerCase().equals("quit")) {
				ui.displayGoodbye();
			}

			else if(userInput.toLowerCase().equals("help"))
				ui.displayHelp();
			else {
				ui.invalidCommand(tokens[0]);
			}
		}
		while(!userInput.toLowerCase().equals("quit"));
	}

	/**
	 * Returns the player object which is the winner of the game according to the current board state, or null if there is no winner.
	 * @param winner is the player that has won the game
	 * @return the player object associated with the winning player, or null if there is no winner.
	 */
	public Player getWinner() {
		Boolean winner = board.checkWinner();

		if(winner == null)	return null;

		return getPlayer(winner.booleanValue());
	}

	/**
	 * Validates the given move, checking whether it is out of bounds.
	 * Will NOT check whether there is already a move at the given position.
	 * 
	 * @param pos The position the move will occupy on the board (indexed 0-8)
	 *
	 * @return true if and only if the move is within bounds, false otherwise.
	 */
	private boolean validateMove(int pos) {
		if(pos < 0 || pos > 8) {
			return false;
		}
		return true;
	}

	/**
	 * Adds a move for the specified player to the specified pos
	 * 
	 * @param pos The position the move will occupy on the board (indexed 0-8)
	 * @param player The boolean representation of the player that is making the move (player 1 is true)
	 *
	 * @return true if the move was successfully made, false otherwise.
	 */
	public boolean makeMove(int pos, boolean player) {
		if(validateMove(pos))	return board.addMove(pos, player);
		else					return false;
	}

	/**
	 * Checks whether the game board has been filled.
	 * 
	 * @return true if and only if the board is full (has 9 moves), false otherwise.
	 */
	public boolean isFull() {
		return board.isFull();
	}

	/**
	 * Returns the player object represented by the given Boolean value
	 * 
	 * @param player The Boolean value representing the Player. True is Player 1, False is Player 2
	 * 
	 * @return the Player object represented by player
	 */
	public Player getPlayer(boolean player) {
		if(player)	return player1;
		else		return player2;
	}

	/**
	 * Changes a player's name.
	 * Does nothing if name is an empty string.
	 * 
	 * @param name The new name
	 * @param player The boolean representation of the player to change the name for (true is player 1)
	 */
	public void changePlayerName(String name, boolean player) {
		//if(name == "")	return;

		if(player)	player1.setName(name);
		else		player2.setName(name);
	}

	/**
	* This method resets all moves
	*/
	public void resetBoard() {
		board.reset();
	}

	/**
	* This method sets new board
	*/
	public Board getBoard() {
		return board;
	}
}