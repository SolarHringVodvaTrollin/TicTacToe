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
		Board board = new Board();
        Player player1 = new Player("Ragnar", 'X');
        Player player2 = new Player("Benedikt", 'O');

        Move move1 = new Move(0, 0, player1);
        Move move2 = new Move(0, 1, player2);
        Move move3 = new Move(0, 2, player1);
        Move move4 = new Move(1, 0, player2);

        board.addMove(move1);
        System.out.println("0.1");
        ConsoleUI.draw(board);

        board.addMove(move2);
        System.out.println("0.2");
        ConsoleUI.draw(board);

        board.addMove(move3);
        System.out.println("0.3");
        ConsoleUI.draw(board);

        board.addMove(move4);
        System.out.println("1.0");
        ConsoleUI.draw(board);
	}
}