package is.ru.tictactoe;

public class TicTacToe {

	private ConsoleUI ui;
	private Board board;
	private Player player1;
	private Player player2;

	public TicTacToe(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;

		board = new Board();
	}

	public static String greet() {
		return "Hello world!";
	}

	public Player checkWinner() {
		return null;
	}

	public Boolean makeMove(Move move) {
		return board.addMove(move);
	}

	public Boolean isFull() {
		return false;
	}

	public static void main(String[] args) {
		/* Placeholder code. Basic workflow:
		   1. Create new UI object
		   2. Make UI object draw welcome screen and get input for player names
		   3. Create new players with the given names
		   4. Pass players to TicTacToe constructor and create the game instance
		   ....
		*/

		ConsoleUI ui = new ConsoleUI();

		Player player1 = new Player("Einstein", true);
		Player player2 = new Player("Hawking", false);
		TicTacToe game = new TicTacToe(player1, player2);

		ui.draw(game.board);
		System.out.println();

		game.makeMove(new Move(1, 1, player1));

		ui.draw(game.board);
		System.out.println();

		game.makeMove(new Move(0, 0, player2));

		ui.draw(game.board);
		System.out.println();
	}
}