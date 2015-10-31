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

		if(in.hasNext()){

			firstPlayerName = in.next();
		}
		else{

			return "kjánaplik";
		}


		return firstPlayerName;
		
	}

	public String getInputSecondPlayer(){
		Scanner in = new Scanner(System.in);

		String secondPlayerName;

		System.out.println("PLayer 2 enter your name:");

		if(in.hasNext()){

			secondPlayerName = in.next();
		}
		else{

			return "kúkalabbi";
		}
		

		return secondPlayerName;

	}

	public int getInputNumber(){

		Boolean validInput = false;

		System.out.print( " please choose a box (0-8): ");

		while(!validInput){
			Scanner in = new Scanner(System.in);
			
			if(in.hasNextInt()){
				int input = in.nextInt();
			
				if(input <= 8 && input >=0){
					validInput = true;
					return input;
				
				}
				else {
					System.out.println("Please enter a number between 0-8!");
				}
			
			}
		
			else {
				System.out.println("Please enter a number between 0-8!");
			}

		}
		return 0;
	}	

}