package is.ru.tictactoe;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TicTacToeTest {
	
    @Test
    public void TestGreet() {
        assertEquals("Hello world!", TicTacToe.greet());
    }
}

