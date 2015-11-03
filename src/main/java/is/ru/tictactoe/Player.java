package is.ru.tictactoe;

public class Player {
	private String name;
	private Boolean symbol;
	//player 1 is true ('X') and player 2 is false ('O')
	private int score;

	/**
	 *Instantiates the class player. Thorw illegalArgumentException if the name contains no characters.
	 *
	 *@param name The name of the player that owns this instance
	 *@param symbol the symbol of the player that owns this instance
	 */
	public Player(String name, Boolean symbol) throws IllegalArgumentException {
		if(name == "")
			throw new IllegalArgumentException("Name cannot be empty");
		
		this.name = name;
		this.symbol = symbol;
		score = 0;
	}

	/**
	 *@return Returns the name of the player that owns this instance
	 */
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

	/**
	 *@return Returns the symbol of the player that owns this instance
	 */
	public Boolean getSymbol(){
		return symbol;
	}

	/**
	 *@return Returns the score of the player that owns this instance
	 */
	public int getScore() {
		return score;
	}

	/**
	 *Increase the score of the player that owns this instance by 1.
	 */
	public void raiseScore() {
		score++;
	}

	/**
	 *Resets the score to 0.
	 */
	public void resetScore() {
		score = 0;
	}
}