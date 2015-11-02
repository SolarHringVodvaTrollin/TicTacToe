package is.ru.tictactoe;

public class TicTacToe {

	// TODO: Dependency injection for the UI? Constructor accepts a UI as a parameter?
	// UI ui;
	private Board board;
	private Player player1;
	private Player player2;

	/**
	 * Creates a new instance of a TicTacToe game.
	 * Players will be named "Player 1" and "Player 2" by default and the board will be empty.
	 */
	public TicTacToe(boolean humanVsHuman) {
		if(humanVsHuman){
			this.player1 = new Player("Player 1", true);
			this.player2 = new Player("Player 2", false);
		}
		else {
			this.player1 = new Player("Player 1", true);
			this.player2 = new AI("Player 2", false);
		}

		board = new Board();
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
		if(name == "")	return;

		if(player)	player1.setName(name);
		else		player2.setName(name);
	}

	public void resetBoard() {
		board.reset();
	}

	/**
	 *  Consider: Put main game code into run() function.
	 *  Then the main function can consist solely of the following:
	 *
	 *  TicTacToe game = new TicTacToe(new UiToUse);
	 *	game.run();
	 */
	public static void main(String[] args) {
		final boolean PLAYER1 = true;
		final boolean PLAYER2 = false;

		ConsoleUI ui = new ConsoleUI();
		
		SaveToFile saveToFile = new SaveToFile();

		boolean firstPlayer = PLAYER1;

		Boolean humanOrComputer = ui.players();
		TicTacToe game = new TicTacToe(humanOrComputer);

		do {
			// TODO: Implement function to return some value representing player's choice.
			//ui.displayOptions()

			/*
			Pseudocode:
			if(playerWantsNameChange) {
				game.changePlayerName(playerThatWantsNameChange);
			}
			*/
			game.resetBoard();
			
			boolean currentPlayer = firstPlayer;

			ui.draw();

			while(game.getWinner() == null && !game.isFull()) {
				ui.draw(game.board);

				while(!game.makeMove(ui.getMove(), currentPlayer)) {
					ui.promptIllegalMove();
				}

				currentPlayer = !currentPlayer;
			}

			Player winner = game.getWinner();

			if(winner != null) {
				winner.raiseScore();
			}

			// If winner is null, ui will display a tie
			ui.display(winner);
			// Swap the player that takes the first turn each round
			firstPlayer = !firstPlayer;
		} while(ui.promptContinue());
	}
}