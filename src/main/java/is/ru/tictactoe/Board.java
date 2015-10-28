package is.ru.tictactoe;

public class Board {
	private Move[][] board;

	public Board() {
		board = new Move[3][3];
		for (int i = 0; i < board.length; i++) {
			for(int j = 0; j < board.length; j++) {
				board[i][j] = null;
			}
		}
	}

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
		return true;
	}
	
}
