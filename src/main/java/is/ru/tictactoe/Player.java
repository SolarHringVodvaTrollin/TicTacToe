package is.ru.tictactoe;

public class Player {
	private String name;
	private Boolean symbol;
	//player 1 is true ('X') and player 2 is false ('O')
	private int score;

	public Player(String name, Boolean symbol) throws IllegalArgumentException {
		if(name == "")
			throw new IllegalArgumentException("Name cannot be empty");
		
		this.name = name;
		this.symbol = symbol;
		score = 0;
	}

	public String getName(){
		return name;
	}

	/**
	 * Sets the name of this player to name
	 *
	 * @param name The new name
	 * 
	 * @throws IllegalArgumentException if name is an empty string
	 */
	public void setName(String name) throws IllegalArgumentException {
		//if(name == "")
		//	throw new IllegalArgumentException("Name cannot be empty");

		this.name = name;
	}

	public Boolean getSymbol(){
		return symbol;
	}

	public int getScore() {
		return score;
	}

	public void raiseScore() {
		score++;
	}

	public void resetScore() {
		score = 0;
	}
}