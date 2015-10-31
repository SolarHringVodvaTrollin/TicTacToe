package is.ru.tictactoe;

public class Board {
	private Move[][] board;
	private int moveCount;

	public Board() {
		board = new Move[3][3];
		for (int i = 0; i < board.length; i++) {
			for(int j = 0; j < board.length; j++) {
				board[i][j] = null;
			}
		}
		moveCount = 0;
	}

	/**
	 * Gets the current board state.
	 * 
	 * @return an array of Moves currently on the board
	 */
	public Move[][] getMoves() {
		return board;
	}

	public Boolean addMove(Move move) {
		int x = move.getX();
		int y = move.getY();

		// Refuse overwriting a move with a new move
		if(board[x][y] != null)
			return false;

		board[x][y] = move;
		moveCount++;
		return true;
	}

	public Boolean isFull() {
		return moveCount == 9;
	}
	
}
