package is.ru.tictactoe;

public class ConsoleUI implements UI {
	public void draw() {
		System.out.println("   |   |   ");
		System.out.println("   |   |   ");
		System.out.println("   |   |   ");
	}

	public void draw(Board board) {
		Move move = board.getMoves();

		for(int i = 0; i < move.length; i++){
			for(int j = 0; j < move.length; j++){
				if(j == 1){
					if(move[i][j] != null){
						Player player = move[i][j].getPlayer();
						System.print("| " + player.getSymbol()  + " |");
					}
					else{
						System.print("|   |");
					}
				}
				else{
					if(move[i][j] != null){
						Player player = move[i][j].getPlayer();
						System.print(" " + player.getSymbol()  + " ");
					}
					else{
						System.print("   ");
					}
				}
			}
		}
	}

	public void getInput() {
		System.out.println("Enter numbers:");
	}


}