package is.ru.tictactoe;

public class Player {
	private String name;
	private char symbol;
	private int score;

	public Player(String name, char symbol) {
		this.name = name;
		this.symbol = symbol;
		score = 0;
	}

	public String getName(){
		return name;
	}

	public char getSymbol(){
		return symbol;
	}

	public int getScore() {
		return score;
	}
}