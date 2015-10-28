package is.ru.tictactoe;

public class Move {
	private int xPos;
	private int yPos;
	private Player player;

	public Move(int x, int y, Player player) throws IllegalArgumentException {
		if((x < 0) || (x > 2) || (y < 0) || (y > 2))
			throw new IllegalArgumentException("Move out of bounds");
		if(player == null)
			throw new IllegalArgumentException("Player cannot be null");
		this.player = player;
		xPos = x;
		yPos = y;
	}

	public int getX() {
		return xPos;
	}

	public int getY() {
		return yPos;
	}

	public Player getPlayer() {
		return player;
	}
}