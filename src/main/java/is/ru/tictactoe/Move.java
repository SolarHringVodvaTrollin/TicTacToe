package is.ru.tictactoe;

public class Move {
	private int xPos;
	private int yPos;
	private Player player;

	public Move(int x, int y, Player player) {
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