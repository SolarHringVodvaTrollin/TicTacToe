package is.ru.tictactoe;

import static org.junit.Assert.*;

import org.junit.Test;

public class BoardTest {

	@Test
	public void testNewBoard() {
		Board board = new Board();
		Move[][] theBoard = new Move[3][3];
		theBoard = board.getMoves();
		Boolean testFails = false;
        for(int i = 0; i < 3; i++)
        {
        	for(int j = 0; j < 3; j++)
        	{
        		if(theBoard[i][j] != null) fail("One instance of the board wasn't null");
        	}
        }
        fail("test failed");
    }
}

