package is.ru.tictactoe;

public class Player {
	private String name;
	// Consider for later: Instead of having a symbol variable, consider instead
	// using a Boolean value where true = 'X' and false = 'O'?
	private char symbol;
	private int score;

	public Player(String name, char symbol) throws IllegalArgumentException {
		if(name == "")
			throw new IllegalArgumentException("Name cannot be empty");
		if(!(symbol == 'X' || symbol == 'O'))
			throw new IllegalArgumentException("Symbol must be either 'X' or 'O'");

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