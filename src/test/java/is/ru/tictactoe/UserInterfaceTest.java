package is.ru.tictactoe;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UserInterfaceTest {
	UserInterface userInterface = new UserInterface();
	@Test
    public void TestShow() {
        assertEquals("__|__|__\n__|__|__\n__|__|__", userInterface.show());
    }    
}

