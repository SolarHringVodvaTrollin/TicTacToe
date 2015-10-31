package is.ru.tictactoe;

public class TicTacToe {

	// TODO: Dependency injection for the UI? Constructor accepts a UI as a parameter?
	// UI ui;
	private Board board;
	private Player player1;
	private Player player2;

	public TicTacToe() {
		this.player1 = new Player("Player 1", true);
		this.player2 = new Player("Player 2", false);

		board = new Board();
	}


	public Player getWinner() {
		Boolean winner = board.checkWinner();

		if(winner == null)	return null;

		return getPlayer(winner.booleanValue());
	}

	public boolean validateMove(int move) {
		if(move < 0 || move > 9) {
			return false;
		}

		return true;
	}

	// Should not accept Player object, but Boolean instead
	public boolean makeMove(int move, boolean player) {
		return board.addMove(new Move(move, player));
	}

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

	public void changePlayerName(String name, boolean player) {
		if(name == "")	return;

		if(player)	player1.setName(name);
		else		player2.setName(name);
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
		TicTacToe game = new TicTacToe();

		boolean firstPlayer = PLAYER1;

		//do {
			// TODO: Implement function to return some value representing player's choice.
			//ui.displayOptions()

			/*
			Pseudocode:
			if(playerWantsNameChange) {
				game.changePlayerName(playerThatWantsNameChange);
			}
			*/

	/*		boolean currentPlayer = firstPlayer;

			while(game.checkWinner() == null && !game.isFull()) {
				ui.draw(game.board);

				while(!game.makeMove(ui.getMove(currentPlayer), currentPlayer)) {
					ui.promptIllegalMove();
				}

				currentPlayer = !currentPlayer;
			}

			Player winner = game.getPlayer(game.checkWinner());

			if(winner != null) {
				winner.raiseScore();
			}

			// If winner is null, ui will display a tie
			ui.display(winner);
		} while(ui.promptContinue());
	*/}
}