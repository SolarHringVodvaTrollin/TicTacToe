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

	public Boolean addMove(int pos, boolean symbol) {
		// Refuse overwriting a move with a new move
		if(board[pos] != null)
			return false;

		board[pos] = new Move(pos, symbol);
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
	*/
	public Boolean checkWinner() {

		//Checking if player = 'X' has won
		//Check all rows
		/*
		[0][1][2]
		[3][4][5]
		[6][7][8]
		*/

		Boolean result = null;

		// Check top row
		if(		board[0] != null && 	board[1] != null && 	board[2] != null) {
			if(	board[0].getSymbol() == board[1].getSymbol() == board[2].getSymbol()) {
				return board[0].getSymbol();
			}
		}
		// Check middle row
		if(		board[3] != null && 	board[4] != null && 	board[5] != null) {
			if(	board[3].getSymbol() == board[4].getSymbol() == board[5].getSymbol()) {
				return board[3].getSymbol();
			}
		}

		// Check bottom row
		if(		board[6] != null && 	board[7] != null && 	board[8] != null) {
			if(	board[6].getSymbol() == board[7].getSymbol() == board[8].getSymbol()) {
				return board[6].getSymbol();
			}
		}

		// Check leftmost column
		if(		board[0] != null && 	board[3] != null && 	board[6] != null) {
			if(	board[0].getSymbol() == board[3].getSymbol() == board[6].getSymbol()) {
				return board[0].getSymbol();
			}
		}

		// Check middle column
		if(		board[1] != null && 	board[4] != null && 	board[7] != null) {
			if(	board[1].getSymbol() == board[4].getSymbol() == board[7].getSymbol()) {
				return board[1].getSymbol();
			}
		}

		// Check rightmost column
		if(		board[2] != null && 	board[5] != null && 	board[8] != null) {
			if(	board[2].getSymbol() == board[5].getSymbol() == board[8].getSymbol()) {
				return board[2].getSymbol();
			}
		}

		// Check left->right diagonal
		if(		board[0] != null && 	board[4] != null && 	board[8] != null) {
			if(	board[0].getSymbol() == board[4].getSymbol() == board[8].getSymbol()) {
				return board[0].getSymbol();
			}
		}

		// Check right->left diagonal
		if(		board[2] != null && 	board[4] != null && 	board[6] != null) {
			if(	board[2].getSymbol() == board[4].getSymbol() == board[6].getSymbol()) {
				return board[2].getSymbol();
			}
		}	

		// If we got here, there is no winner and we return null
		return null;
	}
}   




