package is.ru.tictactoe;

public class Board {
	private Move[] board;
	private int moveCount;

	public Board() {
		board = new Move[9];
		moveCount = 0;
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

	/**
	*Returns the winner's symbol which is true for 'X' and false for 'O'.
	*If neither player is a winner then it will return NULL. 
	*Checks all rows, columns and diagonal lines for the same symbol across.
	*
	public Boolean checkWinner() {

		//Checking if player = 'X' has won
		//Check all rows
		if((board[0].getSymbol() == true) && (board[1].getSymbol() == true) && (board[2].getSymbol() == true)) {
			return true;
		};
		if(board[3].getSymbol() == true && board[4].getSymbol() == true && board[5].getSymbol() == true) {
			return true;
		}
		if(board[6].getSymbol() == true && board[7].getSymbol() == true && board[8].getSymbol() == true) {
			return true;
		}
		//Check all columns
		if(board[0].getSymbol() == true && board[3].getSymbol() == true && board[6].getSymbol() == true) {
			return true;
		}
		if(board[1].getSymbol() == true && board[4].getSymbol() == true && board[7].getSymbol() == true) {
			return true;
		}
		if(board[2].getSymbol() == true && board[5].getSymbol() == true && board[8].getSymbol() == true) {
			return true;
		}
		// Check diagonal
		if(board[0].getSymbol() == true && board[4].getSymbol() == true && board[8].getSymbol() == true) {
			return true;
		}
		if(board[2].getSymbol() == true && board[4].getSymbol() == true && board[6].getSymbol() == true) {
			return true;
		}
		//Checking if player = 'O' has won
		//Check all rows
		if((board[0].getSymbol() == false) && (board[1].getSymbol() == false) && (board[2].getSymbol() == false)) {
			return false;
		};
		if(board[3].getSymbol() == false && board[4].getSymbol() == false && board[5].getSymbol() == false) {
			return false;
		}
		if(board[6].getSymbol() == false && board[7].getSymbol() == false && board[8].getSymbol() == false) {
			return false;
		}
		//Check all columns
		if(board[0].getSymbol() == false && board[3].getSymbol() == false && board[6].getSymbol() == false) {
			return false;
		}
		if(board[1].getSymbol() == false && board[4].getSymbol() == false && board[7].getSymbol() == false) {
			return false;
		}
		if(board[2].getSymbol() == false && board[5].getSymbol() == false && board[8].getSymbol() == false) {
			return false;
		}
		// Check diagonal
		if(board[0].getSymbol() == false && board[4].getSymbol() == false && board[8].getSymbol() == false) {
			return false;
		}
		if(board[2].getSymbol() == false && board[4].getSymbol() == false && board[6].getSymbol() == false) {
			return false;
		}
		return null;	
	}
}   




