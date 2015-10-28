package is.ru.tictactoe;

import static org.junit.Assert.*;

import org.junit.Test;

public class MoveTest {
	
	@Test
    public void testNewMove() {
    	Player player = new Player("Einstein", 'X');
       	Move move = new Move(1, 2, player);
       	assertEquals(1, move.getX());
       	assertEquals(2, move.getY());
       	assertSame(player, move.getPlayer());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalNewMove() {
    	Player player = new Player("Einstein", 'X');
    	Move move = new Move(0, 3, player);
    	move = new Move(3, 0, player);
    	move = new Move(-1, 0, player);
    	move = new Move(0, -1, player);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullPlayer() {
    	Move move = new Move(0, 0, null);
    }
}

