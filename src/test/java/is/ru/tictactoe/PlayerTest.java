package is.ru.tictactoe;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest {
	@Test
    public void testNewPlayer() {
        Player player = new Player("Einstein", true);
        assertEquals("Einstein", player.getName());
        assertTrue(player.getSymbol());
        assertEquals(0, player.getScore());

        player = new Player("Hawking", false);
        assertEquals("Hawking", player.getName());
        assertFalse(player.getSymbol());
        assertEquals(0, player.getScore());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalName() {
    	Player player = new Player("", true);
    }

    @Test
    public void testPlayerScore() {
    	Player player = new Player("Edison", true);
    	assertEquals(0, player.getScore());

    	player.raiseScore();
    	assertEquals(1, player.getScore());

    	player.resetScore();
    	assertEquals(0, player.getScore());
    }

}

