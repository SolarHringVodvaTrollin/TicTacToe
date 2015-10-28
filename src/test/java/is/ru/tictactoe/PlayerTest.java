package is.ru.tictactoe;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest {
	@Test
    public void testNewPlayer() {
        Player player = new Player("Einstein", 'X');
        assertEquals("Einstein", player.getName());
        assertEquals('X', player.getSymbol());
        assertEquals(0, player.getScore());

        player = new Player("Hawking", 'O');
        assertEquals("Hawking", player.getName());
        assertEquals('O', player.getSymbol());
        assertEquals(0, player.getScore());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalName() {
    	Player player = new Player("", 'X');
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalSymbol() {
    	Player player = new Player("Turing", 'K');
    }

    @Test
    public void testPlayerScore() {
    	Player player = new Player("Edison", 'X');
    	assertEquals(0, player.getScore());

    	player.raiseScore();
    	assertEquals(1, player.getScore());

    	player.resetScore();
    	assertEquals(0, player.getScore());
    }

}

