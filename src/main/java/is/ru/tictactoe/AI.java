package is.ru.tictactoe;

import java.util.Random;

public class AI extends Player{
	
	public int generateMove(Board board) {
		Random rmove = new Random();
		int randomMove = rmove.nextInt(8);
		if(board.isFull()) {
			return null;
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
					board.addMove(i);
					return;
				}
			}
		}
	}
}