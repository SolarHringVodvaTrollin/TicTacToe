package is.ru.tictactoe;

public class Board {
	private Move[] board;
	private int moveCount;

	public Board() {
		board = new Move[9];
		moveCount = 0;
	}

	public Boolean checkWinner() {
		return null;
	}

	/**
	 * Gets the current board state.
	 * 
	 * @return an array of Moves currently on the board
	 */
	public Move[] getMoves() {
		return board;
	}

	/**
	 * Gets the move currently on given (zero-indexed) board square
	 *
	 * @return the Move at square or null if square is empty
	 */
	public Move getMoveAt(int square) {
		if(square < 0 || square > 8) {
			return null;
		}

		return board[square];
	}

	public Boolean addMove(Move move) {
		int square = move.getSquare();

		// Refuse overwriting a move with a new move
		if(board[square] != null)
			return false;

		board[square] = move;
		moveCount++;
		return true;
	}

	public Boolean isFull() {
		return moveCount == 9;
	}
	
}
