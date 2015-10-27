package is.ru.tictactoe;

public class ConsoleUI implements UI {
	public void draw() {
		System.out.println("Hello world!");
	}

	public void getInput() {
		System.out.println("Enter numbers:");
	}
}