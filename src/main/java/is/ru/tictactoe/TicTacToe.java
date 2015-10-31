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

	public static String greet() {
		return "Hello world!";
	}

	public Player checkWinner() {
		return null;
	}

	public Boolean validateMove(int move) {
		return false;
	}

	// Should not accept Player object, but Boolean instead
	public Boolean makeMove(int move, Player player) {
		return false;
	}

	public Boolean isFull() {
		return false;
	}

	// Returns the player object represented by the Boolean value
	// ATTENTION: Allowing the user to get the Player object directly defeats the purpose of having it private. FIX
	public Player getPlayer(Boolean player) {
		if(player)	return player1;
		else		return player2;
	}

	public void changePlayerName(String name, Boolean player) {
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
		final Boolean PLAYER1 = true;
		final Boolean PLAYER2 = false;

		ConsoleUI ui = new ConsoleUI();
		TicTacToe game = new TicTacToe();

	//	do {
			// TODO: Implement function to return some value representing player's choice.
			//ui.displayOptions()

			/*
			Pseudocode:
			if(playerWantsNameChange) {
				game.changePlayerName(playerThatWantsNameChange);
			}
			*/

	/*		Boolean currentPlayer = PLAYER1;

			while(game.checkWinner() == null && !game.isFull()) {
				ui.draw(game.board);

				int move = ui.getMove(currentPlayer);

				game.makeMove(ui.getMove(currentPlayer), game.getPlayer(currentPlayer));

				while(game.makeMove(ui.getMove(currentPlayer)))

				currentPlayer = !currentPlayer;
			}

			Player winner = game.checkWinner();

			if(winner != null) {
				winner.raiseScore();
			}

			// If winner is null, ui will display a tie
			ui.display(winner);
		} while(ui.promptContinue());*/
	}
}