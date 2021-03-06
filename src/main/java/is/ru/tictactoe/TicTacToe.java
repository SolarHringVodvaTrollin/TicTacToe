package is.ru.tictactoe;

import java.util.Random;

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
					if(currentPlayer == PLAYER1) {
						while(!makeMove(ui.getMove(), currentPlayer)) {
							ui.promptIllegalMove();
						}
					}
					else {
						makeRandomMove(currentPlayer);
					}
				}

				currentPlayer = !currentPlayer;
			}

			Player winner = getWinner();

			if(winner != null) {
				winner.raiseScore();
				if(winner.getSymbol() == true) {
					save.saveGameToFile(player1.getName());
				}
				else {
					save.saveGameToFile(player2.getName());
				}
			}

			// If winner is null, UI will report a tie
			ui.draw(board);
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

			if(tokens.length == 0) continue;

			if(userInput.toLowerCase().startsWith("play")) {
				if(tokens.length > 1) {
					if(tokens[1].toLowerCase().equals("computer")) {
						play(COMPUTER);
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
						save.savePlayerToFile(tokens[2], 0);
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
		save.close();
	}

	/**
	 * Returns the player object which is the winner of the game according to the current board state, or null if there is no winner.
	 *
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
	 * Generates a random move for the specified player
	 *
	 * @param player The player to generate the move for
	 * 
	 * @return true if the move was successfully made, false otherwise.
	  */
	public boolean makeRandomMove(boolean player) {
		Random rmove = new Random();
		int randomMove = rmove.nextInt(9);
		
		if(isFull()) {
			return false;
		}

		if(board.getMoveAt(randomMove) == null) {
			return board.addMove(randomMove, player);
		}
		else {
			for(int i = randomMove + 1; i <= 9; i++){
				if(i == 9) {
					i = 0;
				}

				if(board.getMoveAt(i) == null){
					return board.addMove(i, player);
				}
			}
		}
		return false;
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
	 * Returns the board associated with current game
	 * 
	 *@return the board
	 */
	public Board getBoard() {
		return board;
	}
}