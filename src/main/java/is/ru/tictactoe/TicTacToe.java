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
		return false;
	}

	public Boolean isFull() {
		return false;
	}

	public static void main(String[] args) {

	}
}