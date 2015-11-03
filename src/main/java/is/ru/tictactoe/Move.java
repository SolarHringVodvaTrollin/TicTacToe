package is.ru.tictactoe;

public class Move {
	private int square;
	private boolean symbol;

	/**
	 *Instantiates a new move.
	 *
	 *@param square Integer that is an index to the board
	 *@param symbol Boolean value that is true or false to represent X or O.
	 *
	 *@Throws IllegalArgumentException if square is lower than 0 and higher than 8.
	 */
	public Move(int square, boolean symbol) throws IllegalArgumentException {
		if((square < 0) || (square > 8))
			throw new IllegalArgumentException("Move is out of bounds");
		this.symbol = symbol;
		this.square = square;
	}
	/**
	 *Returns square for the given move
	 */
	public int getSquare() {
		return square;
	}

	/**
	 *Returns true or false
	 */
	public boolean getSymbol() {
		return symbol;
	}
}