package is.ru.tictactoe;

import static org.junit.Assert.*;

import org.junit.Test;
import java.io.ByteArrayInputStream;

public class ConsoleUITest {
	@Test
    public void testGetMove() {
        String input = "4\nstring\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ConsoleUI ui = new ConsoleUI(in, System.out);

        // Input is 4
        assertEquals(4, ui.getMove());

        // Input is "string"
        assertEquals(-1, ui.getMove());
    }

    @Test
    public void testPromptContinue() {
    /*    String input = "n\nN\nj\ny\nY\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ConsoleUI ui = new ConsoleUI(in);

        in = new ByteArrayInputStream("n".getBytes());
        assertFalse(ui.promptContinue());

        in = new ByteArrayInputStream("N".getBytes());
        assertFalse(ui.promptContinue());

        in = new ByteArrayInputStream("longstring".getBytes());
        assertFalse(ui.promptContinue());

        in = new ByteArrayInputStream("y".getBytes());
        assertTrue(ui.promptContinue());

        in = new ByteArrayInputStream("Y".getBytes());
        assertTrue(ui.promptContinue());
    */}
}
