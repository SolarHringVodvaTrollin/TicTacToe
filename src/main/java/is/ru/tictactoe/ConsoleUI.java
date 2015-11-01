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

	public int getMove() {
		System.out.println("Enter square: ");

		Scanner in = new Scanner(System.in);

		if(in.hasNextInt()) {
			return in.nextInt();
		}

		return 0;
	}

	public boolean promptContinue() {
		Scanner in = new Scanner(System.in);
		System.out.println("Would you like to play another round? [y/n] ");

		while(true) {
			if(in.hasNext()) {
				String input = in.next();

				if(input == "y" || input == "Y")
					return true;
				else if(input == "n" || input == "N")
					return false;
				else {
					System.out.println("Illegal input: '" + input + "'. Please enter either 'y' or 'n'");
				}
			}
			in.reset();
		}
	}

	public void promptIllegalMove() {
		System.out.println("Illegal move. Is the square already occupied or are you trying to make an out-of-bounds move?");
	}

	public void display(Player winner) {
		if(winner == null) {
			System.out.println("It's a tie!");
		}
		else {
			System.out.println(winner.getName() + "has won!");
		}
	}

	public void displayScore(Player p1, Player p2) {
		System.out.println("Current score:");
		System.out.println(p1.getName() + ":\t" + p1.getScore());
		System.out.println(p2.getName() + ":\t" + p2.getScore());
	}

	public String displayOptions() {
		System.out.println("[N]ew round\n[S]core\n[Q]uit");

		Scanner in = new Scanner(System.in);

		boolean isValid;

		while(true) {
			if(in.hasNextLine()) {
				String input = in.nextLine();

				if(	input == "n" || input == "N" ||
					input == "s" || input == "S" ||
					input == "q" || input == "Q")
						return input;
				else {
					System.out.println("Illegal input. Try again.");
				}
			}
			in.reset();
		}
	}
}