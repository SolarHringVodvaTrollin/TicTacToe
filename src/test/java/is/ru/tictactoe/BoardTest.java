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
    public void testGetMoves() {
        Board board = new Board();
        Player player1 = new Player("Ragnar", 'X');
        Player player2 = new Player("Benedikt", 'O');

        Move move1 = new Move(0, 0, player1);
        Move move2 = new Move(0, 1, player2);
        Move move3 = new Move(0, 2, player1);
        Move move4 = new Move(1, 0, player2);

        board.addMove(move1);
        board.addMove(move2);
        board.addMove(move3);
        board.addMove(move4);

        Move[][] moves = board.getMoves();

        assertSame(move1, moves[0][0]);
        assertSame(move2, moves[0][1]);
        assertSame(move3, moves[0][2]);
        assertSame(move4, moves[1][0]);

        assertNull(moves[1][1]);
        assertNull(moves[1][2]);
        assertNull(moves[2][0]);
        assertNull(moves[2][1]);
        assertNull(moves[2][2]);
    }

    @Test
    public void testAddMove() {
        Board board = new Board();
        Move move = new Move(0, 0, new Player("Turing", 'X'));

        // Add a new move to the board, should return true because unoccupied
        assertTrue(board.addMove(move));
        // Check if the move is actually on the board
        assertSame(move, board.getMoves()[0][0]);

        Move move2 = new Move(0, 0, new Player("Lovelace", 'O'));

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
                board.addMove(new Move(i, j, new Player("Dalton", 'X')));
            }
        }

        // Board is full
        assertTrue(board.isFull());
    }
}
