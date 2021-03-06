package is.ru.tictactoe;

import static org.junit.Assert.*;

import org.junit.Test;

public class TicTacToeTest {

    @Test
    public void testGetPlayer() {
    	TicTacToe game = new TicTacToe();

    	Player player1 = game.getPlayer(true);
    	Player player2 = game.getPlayer(false);

    	assertEquals("Player 1", player1.getName());
    	assertEquals("Player 2", player2.getName());

    	assertTrue(player1.getSymbol());
    	assertFalse(player2.getSymbol());
    }

    @Test
    public void testGetWinner() {
        TicTacToe game = new TicTacToe();

        assertNull(game.getWinner());

        game.makeMove(0, true);
        game.makeMove(1, true);
        game.makeMove(2, true);

        assertSame(game.getPlayer(true), game.getWinner());
    }

    @Test
    public void testChangePlayerName() {
    	TicTacToe game = new TicTacToe();

    	Player player1 = game.getPlayer(true);
    	Player player2 = game.getPlayer(false);

    	game.changePlayerName("Einstein", true);
    	game.changePlayerName("Hawking", false);

    	assertEquals("Einstein", player1.getName());
    	assertEquals("Hawking", player2.getName());
    }

    @Test
    public void testMakeMove() {
    	TicTacToe game = new TicTacToe();

    	for(int i = 0; i < 9; i++) {
    		assertTrue(game.makeMove(i, true));
    	}

    	assertFalse(game.makeMove(10, false));
    	assertFalse(game.makeMove(-1, false));
        assertFalse(game.makeMove(3, false));
    }
}
