package is.ru.tictactoe;
import java.lang.NullPointerException;

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
	 * Verifies that three moves exist (are not null).
	 *
	 * @param m1 The first move
	 * @param m2 The second move
	 * @param m3 The third move
	 *
	 * @return true if and only if NONE of the moves are null. False otherwise.
	*/
	private boolean checkThree(Move m1, Move m2, Move m3) {
		if(m1 == null)	return false;
		if(m2 == null)	return false;
		if(m3 == null)	return false;
		return true;
	}

	/**
	*Returns the winner's symbol which is true for 'X' and false for 'O'.
	*If neither player is a winner then it will return NULL. 
	*Checks all rows, columns and diagonal lines for the same symbol across.
	*
	*/
	public Boolean checkWinner() {
		// TODO: Refine the checkWinner() method.
		// Note: The only time a winner is possible is right after a player's turn.
		// If a winner is found, the winner will be the player that just ended his turn.
		// So maybe pass to the function the that just made his turn, and his move position,
		// and only check the relevant squares according to the move just made.
		
		/*
		[0][1][2]
		[3][4][5]
		[6][7][8]
		*/

		//Check rows
	    for(int i = 0; i <= 6; i+=3) {
	      if(checkThree(board[i], board[i+1], board[i+2])) {
	        if((board[i].getSymbol() == board[i+1].getSymbol()) && (board[i+1].getSymbol() == board[i+2].getSymbol())) {
	          return board[i].getSymbol();
	        }
	      }
	    }

	    //Check columns
	    for(int i = 0; i < 3; i++) {
	      if(checkThree(board[i], board[i+3], board[i+6])) {
	        if((board[i].getSymbol() == board[i+3].getSymbol()) && (board[i+3].getSymbol() == board[i+6].getSymbol())) {
	          return board[i].getSymbol();
	        }
	      }
	    }

	    // Check left->right diagonal
	    if(checkThree(board[0], board[4], board[8])) {
	      if((board[0].getSymbol() == board[4].getSymbol()) && (board[4].getSymbol() == board[8].getSymbol())) {
	        return board[0].getSymbol();
	      }
	    }

	    // Check right->left diagonal
	    if(checkThree(board[2], board[4], board[6])) {
	      if((board[2].getSymbol() == board[4].getSymbol()) && (board[4].getSymbol() == board[6].getSymbol())) {
	        return board[2].getSymbol();
	      }
	    }

		// If we get here, no winner was found, and we return null
		return null;
	}
}   




