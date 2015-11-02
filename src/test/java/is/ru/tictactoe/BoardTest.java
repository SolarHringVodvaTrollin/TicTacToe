package is.ru.tictactoe;

import static org.junit.Assert.*;

import org.junit.Test;

public class BoardTest {

	@Test
	public void testNewBoard() {
		Board board = new Board();
		Move[] moves = board.getMoves();

        for(int i = 0; i < 9; i++) {
            if(moves[i] != null)
                fail("Board was not empty at creation");
        }
    }

    @Test
    public void testGetMoves() {
        Board board = new Board();

        Move move1 = new Move(0, true);
        Move move2 = new Move(2, false);
        Move move3 = new Move(4, true);
        Move move4 = new Move(7, false);

        board.addMove(move1);
        board.addMove(move2);
        board.addMove(move3);
        board.addMove(move4);

        Move[] moves = board.getMoves();

        assertSame(move1, moves[0]);
        assertSame(move2, moves[2]);
        assertSame(move3, moves[4]);
        assertSame(move4, moves[7]);

        assertNull(moves[1]);
        assertNull(moves[3]);
        assertNull(moves[5]);
        assertNull(moves[6]);
        assertNull(moves[8]);
    }

    @Test
    public void testGetMoveAt() {
        Board board = new Board();

        assertNull(board.getMoveAt(-1));
        assertNull(board.getMoveAt(9));

        Move move = new Move(3, true);
        board.addMove(move);

        assertSame(move, board.getMoveAt(3));
    }

    @Test
    public void testAddMove() {
        Board board = new Board();
        Move move = new Move(0, true);

        // Add a new move to the board, should return true because unoccupied
        assertTrue(board.addMove(move));
        // Check if the move is actually on the board
        assertSame(move, board.getMoves()[0]);

        Move move2 = new Move(0, false);

        // Try adding a new move to an occupied space
        assertFalse(board.addMove(move2));
        // Verify that the original move was not overwritten
        assertSame(move, board.getMoves()[0]);
    }

    @Test
    public void testIsFull() {
        Board board = new Board();

        // Board is empty
        assertFalse(board.isFull());

        // Fill the board with moves
        for(int i = 0; i < 9; i++) {
            board.addMove(new Move(i, true));
        }

        // Board is full
        assertTrue(board.isFull());
    }

    // Test all winning moves for both players
    @Test
    public void testCheckWinner() {
        //Testing for player 'X'
        Board board = new Board();
        //Top row
        Move move1 = new Move(0, true);
        Move move2 = new Move(1, true);
        Move move3 = new Move(2, true);

        board.addMove(move1);
        board.addMove(move2);
        board.addMove(move3);

        assertTrue(board.checkWinner());

        //Second column
        Move move4 = new Move(3, true);
        Move move5 = new Move(6, true);

        board.addMove(move4);
        board.addMove(move5);

        assertTrue(board.checkWinner());

        //Diagonal from upper left
        Move move6 = new Move(4, true);
        Move move7 = new Move(8, true);

        board.addMove(move6);
        board.addMove(move7);

        assertTrue(board.checkWinner());

        //Third column
        Move move15 = new Move(5, true);

        board.addMove(move15);

        assertTrue(board.checkWinner());

        //Bottom row
        Move move16 = new Move(7, true);

        board.addMove(move16);

        assertTrue(board.checkWinner());

        //================================
        //Now testing for player 'O'
    
        /*Board board2 = new Board();
        //Middle row
        Move move8 = new Move(3, false);
        Move move9 = new Move(4, false);  
        Move move10 = new Move(5, false);

        board2.addMove(move8);
        board2.addMove(move9);
        board2.addMove(move10);

        assertFalse(board2.checkWinner());

        //Second column
        Move move11 = new Move(1, false);
        Move move12 = new Move(7, false);

        board2.addMove(move11);
        board2.addMove(move12);

        assertFalse(board2.checkWinner());

        //Diagonal from upper right
        Move move13 = new Move(2, false);
        Move move14 = new Move(6, false);

        board2.addMove(move13);
        board2.addMove(move14);

        assertFalse(board2.checkWinner());

        //Check if neither has won
        Move move17 = new Move(6, true);

        board2.addMove(move17);

        assertNull(checkWinner());*/

    }
}
