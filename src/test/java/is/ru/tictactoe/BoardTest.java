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

        board.addMove(0, true);
        board.addMove(2, false);
        board.addMove(4, true);
        board.addMove(7, false);

        Move[] moves = board.getMoves();

        assertTrue(moves[0].getSymbol());
        assertFalse(moves[2].getSymbol());
        assertTrue(moves[4].getSymbol());
        assertFalse(moves[7].getSymbol());

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

        board.addMove(3, true);

        assertTrue(board.getMoveAt(3).getSymbol());
    }

    @Test
    public void testAddMove() {
        Board board = new Board();

        // Add a new move to the board, should return true because unoccupied
        assertTrue(board.addMove(0, true));
        // Check if the move is actually on the board
        assertTrue(board.getMoves()[0].getSymbol());

        // Try adding a new move to an occupied space
        assertFalse(board.addMove(0, false));
        // Verify that the original move was not overwritten
        assertTrue(board.getMoves()[0].getSymbol());
    }

    @Test
    public void testIsFull() {
        Board board = new Board();

        // Board is empty
        assertFalse(board.isFull());

        // Fill the board with moves
        for(int i = 0; i < 9; i++) {
            board.addMove(i, true);
        }

        // Board is full
        assertTrue(board.isFull());
    }
}
