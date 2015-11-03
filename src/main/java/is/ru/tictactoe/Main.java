package is.ru.tictactoe;

public class Main {
	public static void main(String[] args) {
		ConsoleUI ui = new ConsoleUI();
		TicTacToe game = new TicTacToe();

		game.run();
	}
}