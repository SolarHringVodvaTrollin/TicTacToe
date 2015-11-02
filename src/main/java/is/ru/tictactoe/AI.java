package is.ru.tictactoe;

import java.util.Random;

 class AI extends Player{

	public AI(String name, Boolean symbol) {
		 super(name, symbol);
	}
	
	public void generateMove(Board board) {
		Random rmove = new Random();
		int randomMove = rmove.nextInt(8);
		if(board.isFull()) {
			return;
		}

		if(board.getMoveAt(randomMove) == null){
			Move move = new Move(randomMove, false);
			board.addMove(move);
		}
		else {
			for(int i = randomMove + 1; i < 9; i++){
				if(i == 9){
					i = 0;
				}
				if(board.getMoveAt(i) == null){
					Move move = new Move(i, false);
					board.addMove(move);
					return;
				}
			}
		}
	}
}