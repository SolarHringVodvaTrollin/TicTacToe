package is.ru.tictactoe;
import java.util.Scanner;

public class ConsoleUI {
	public ConsoleUI() {
		
	}

	public void draw() {
		System.out.println("   |   |   ");
		System.out.println("   |   |   ");
		System.out.println("   |   |   ");
	}

	public static void draw(Board board) {
		Move[][] move = board.getMoves();

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
		}
	}

	
	public String getInputFirstPlayer(){
		
		Scanner in = new Scanner(System.in);

		String firstPlayerName;

		System.out.println("PLayer 1 enter your name:");

		firstPlayerName = in.next();

		return firstPlayerName;
		
	}

	public String getInputSecondPlayer(){
		Scanner in = new Scanner(System.in);

		String secondPlayerName;

		System.out.println("PLayer 2 enter your name:");

		secondPlayerName = in.next();

		return secondPlayerName;

	}

	public void getInputCoordinates(){
		System.out.println("PLayer enter your name:");

	}


}