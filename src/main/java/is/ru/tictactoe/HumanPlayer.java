package is.ru.tictactoe;

public class HumanPlayer extends Player {
	/**
	 *Intatiatez the class humanPlayer as a child of Player
	 *@param name of the player
	 *@param symbol of the player
	 */
	public HumanPlayer(String name, Boolean symbol) throws IllegalArgumentException {
		super(name, symbol);
	}
}