package is.ru.tictactoe;

public class ConsoleUI {
	public ConsoleUI() {
		
	}

	public void draw() {
		System.out.println("   |   |   ");
		System.out.println("   |   |   ");
		System.out.println("   |   |   ");
	}

	public static void draw(Board board) {
	/*	Move[][] move = board.getMoves();

		for(int i = 0; i < move.length; i++){
			for(int j = 0; j < move.length; j++){

				if(j == 1){ //Tegar j er 1 ta baetum vid vid linu til ad afmarka interfacid
					if(move[i][j] != null){
						Player player = move[i][j].getPlayer();
						//Tegar buid er ad adda true false fidusnum
						if(player.getSymbol()){
							System.out.print("| X |");
						}
						else{
							System.out.print("| O |");	
						}
					}
					else{
						System.out.print("|   |");
					}
				}
				else{ //Engar linur til ad afmarka interfacid
					if(move[i][j] != null){
						Player player = move[i][j].getPlayer();
						//Tegar buid er ad adda True False fidusnum
						if(player.getSymbol()) {
							System.out.print(" X ");
						}
						else {
							System.out.print(" O ");
						}
					}
					else{
						System.out.print("   ");
					}
				}
			}
			System.out.println();
		}*/
	}

	public void getInput() {
		System.out.println("Enter numbers:");
	}


}