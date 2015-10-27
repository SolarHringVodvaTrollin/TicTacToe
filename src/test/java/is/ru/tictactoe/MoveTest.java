package is.ru.tictactoe;

import static org.junit.Assert.*;

import org.junit.Test;

public class MoveTest {
	
	@Test
    public void testNewMove() {
    	Player player = new Player("Benedikt", 'X');
       	Move move = new Move(1, 2, player);
       	assertEquals(1, move.getX());
       	assertEquals(2, move.getY());
       	assertSame(player, move.getPlayer());
    }
}

