package is.ru.tictactoe;

import java.util.Random;

	/**
	 *Intatiatez the class computerPlayer as a child of Player
	 */
 class ComputerPlayer extends Player{

	public ComputerPlayer(String name, Boolean symbol) {
		 super(name, symbol);
	}
	
	/**
	 *Generate a move for the computer
	 *@param takes in the board and where there are moves
	 *
	 *@return the index value of where the move should be inserted
	 */
	public int generateMove(Board board) {
		Random rmove = new Random();
		int randomMove = rmove.nextInt(9);
		
		if(board.isFull()) {
			return -1;
		}

		if(board.getMoveAt(randomMove) == null) {
			return randomMove;
		}
		else {
			for(int i = randomMove + 1; i <= 9; i++){
				if(i == 9) {
					i = 0;
				}

				if(board.getMoveAt(i) == null){
					return i;
				}
			}
		}
		return -1;
	}
}