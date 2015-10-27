package is.ru.tictactoe;

import static org.junit.Assert.*;

import org.junit.Test;

public class BoardTest {

	@Test
	public void testNewBoard() {
		Board board = new Board();
		Move[][] theBoard = board.getMoves();
        for(int i = 0; i < 3; i++) {
        	for(int j = 0; j < 3; j++) {
        		if(theBoard[i][j] != null) fail("A new board was created and a section wasn't null");
        	}
        }
    }

    @Test
    public void testAddMove() {
        Board board = new Board();
        Move move = new Move(0, 0, new Player("Ragnar", 'X'));

        // Add a new move to the board, should return true because unoccupied
        assertTrue(board.addMove(move));
        // Check if the move is actually on the board
        assertSame(move, board.getMoves()[0][0]);

        Move move2 = new Move(0, 0, new Player("Benedikt", 'O'));

        // Try adding a new move to an occupied space
        assertFalse(board.addMove(move2));
        // Verify that the original move was not overwritten
        assertSame(move, board.getMoves()[0][0]);
    }
}

