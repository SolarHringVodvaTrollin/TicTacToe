package is.ru.tictactoe;

import static org.junit.Assert.*;

import org.junit.Test;

public class MoveTest {
	
  @Test
  public void testNewMove() {
  	Move move = new Move(0, true);

  	assertEquals(0, move.getSquare());
  	assertTrue(move.getSymbol());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOutOfBoundsMove() {
    Move move = new Move(-1, true);
    move = new Move(9, false);
  }
}

