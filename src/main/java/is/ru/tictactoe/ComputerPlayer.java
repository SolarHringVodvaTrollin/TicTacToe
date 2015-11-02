package is.ru.tictactoe;

import java.util.Random;

 class ComputerPlayer extends Player{

	public ComputerPlayer(String name, Boolean symbol) {
		 super(name, symbol);
	}
	
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