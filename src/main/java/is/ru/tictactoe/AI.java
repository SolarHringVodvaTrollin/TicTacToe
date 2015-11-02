package is.ru.tictactoe;

import java.util.Random;

 class AI extends Player{

	public AI(String name, Boolean symbol) {
		 super(name, symbol);
	}
	
	@Override
	public int generateMove(Board board) {
		Random rmove = new Random();
		int randomMove = rmove.nextInt(8);
		if(board.isFull()) {
			return -1;
		}

		if(board.getMoveAt(randomMove) == null){
			board.addMove(randomMove, false);
		}
		else {
			for(int i = randomMove + 1; i < 9; i++){
				if(i == 9){
					i = 0;
				}
				if(board.getMoveAt(i) == null){
					board.addMove(i, false);
					return i;
				}
			}
		}
		return -1;
	}
}