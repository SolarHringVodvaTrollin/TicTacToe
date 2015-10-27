package is.ru.tictactoe;

public class Player {
	private String name;
	private char symbol;
	private int score;

	public void Player(String name, char symbol) {
		this.name = name;
		this.symbol = symbol;
		score = 0;
	}
}