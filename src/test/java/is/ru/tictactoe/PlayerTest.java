package is.ru.tictactoe;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest {
	@Test
    public void testNewPlayer() {
        Player player = new Player("Benedikt", 'X');
        assertEquals("Benedikt", player.getName());
        assertEquals('X', player.getSymbol());
        assertEquals(0, player.getScore());
    }

}

