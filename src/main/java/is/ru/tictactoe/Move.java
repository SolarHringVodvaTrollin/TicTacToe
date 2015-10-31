package is.ru.tictactoe;

public class Move {
	private int square;
	private Boolean symbol;

	public Move(int square, boolean symbol) throws IllegalArgumentException {
		if((square < 0) || (square > 8))
			throw new IllegalArgumentException("Move is out of bounds");
		this.symbol = symbol;
		this.square = square;
	}

	public int getSquare() {
		return square;
	}

	public Boolean getSymbol() {
		return symbol;
	}
}