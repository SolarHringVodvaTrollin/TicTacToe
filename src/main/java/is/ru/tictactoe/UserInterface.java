package is.ru.tictactoe;

public class UserInterface {
	int[][] ticTacToeUserInterface = new int[3][3];

	public void UserInterface() {
		for(int i = 0; i < ticTacToeUserInterface.length; i++)
		{
			for(int j = 0; j < ticTacToeUserInterface.length; j++)
			{
				ticTacToeUserInterface[i][j] = 0;
			}
		}
	}

	public void show()
	{
		System.out.println("__|__|__");
		System.out.println("__|__|__");
		System.out.println("  |  |  ");
	}
}