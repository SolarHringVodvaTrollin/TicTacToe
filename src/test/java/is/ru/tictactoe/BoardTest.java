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

        Boolean x = true;
        Boolean o = false;

        Move move1 = new Move(0, x);
        Move move2 = new Move(2, o);
        Move move3 = new Move(4, x);
        Move move4 = new Move(7, o);

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
    public void testAddMove() {
        Board board = new Board();
        Move move = new Move(0, 0, new Player("Turing", true));

        // Add a new move to the board, should return true because unoccupied
        assertTrue(board.addMove(move));
        // Check if the move is actually on the board
        assertSame(move, board.getMoves()[0][0]);

        Move move2 = new Move(0, 0, new Player("Lovelace", false));

        // Try adding a new move to an occupied space
        assertFalse(board.addMove(move2));
        // Verify that the original move was not overwritten
        assertSame(move, board.getMoves()[0][0]);
    }

    @Test
    public void testIsFull() {
        Board board = new Board();

        // Board is empty
        assertFalse(board.isFull());

        // Fill the board with moves
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                board.addMove(new Move(i, j, new Player("Dalton", true)));
            }
        }

        // Board is full
        assertTrue(board.isFull());
    }
}
