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
    public void testChangePlayerName() {
    	TicTacToe game = new TicTacToe();

    	Player player1 = game.getPlayer(true);
    	Player player2 = game.getPlayer(false);

    	game.changePlayerName("Einstein", true);
    	game.changePlayerName("Hawking", false);

    	assertEquals("Einstein", player1.getName());
    	assertEquals("Hawking", player2.getName());

    	game.changePlayerName("", true);

    	assertEquals("Einstein", player1.getName());
    }

    @Test
    public void testValidateMove() {
    	TicTacToe game = new TicTacToe();

    	for(int i = 1; i <= 9; i++) {
    		assertTrue(game.validateMove(i));
    	}

    	assertFalse(game.validateMove(10));

    	assertFalse(game.validateMove(-1));
    }
}
