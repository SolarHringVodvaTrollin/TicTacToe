package is.ru.tictactoe;
import java.util.Scanner;

public class ConsoleUI {
	public ConsoleUI() {
		
	}

	public void draw() {
		System.out.println(" 0 | 1 | 2 ");
		System.out.println(" 3 | 4 | 5 ");
		System.out.println(" 6 | 7 | 8 ");
		System.out.println();
	}

	public static void draw(Board board) {
		Move[] move = board.getMoves();

		for(int i = 0; i < move.length; i++){
			if(i == 3 || i == 6){

				System.out.println();
			}
			if(i == 1 || i == 4 || i == 7){

				if(move[i] == null){
					System.out.print("|   |" );
				}
				else if(move[i].getSymbol() == true){
					System.out.print("| X |" );
				}
				else if(move[i].getSymbol() == false){
					System.out.print("| O |" );
				}
			}	
			else
			{
				if(move[i] == null){
					System.out.print("   " );
				}
				else if(move[i].getSymbol() == true){
					System.out.print(" X " );
				}
				else if(move[i].getSymbol() == false){
					System.out.print(" O " );
				}
			}
		}
		System.out.println();
	}

	public int getMove() {
		System.out.println("Enter square: ");
		Scanner in = new Scanner(System.in);

		if(in.hasNextInt()) {
			return in.nextInt();
		}
		return 0;
	}
	
	public String getInputFirstPlayer(){
		Scanner in = new Scanner(System.in);
		String firstPlayerName;
		System.out.println("Enter name for Player 1:");

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
		System.out.println("Enter name for Player 2:");

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

	public boolean promptContinue() {
		Scanner in = new Scanner(System.in);
		System.out.println("Would you like to play another round? [y/n] ");

		while(true) {
			if(in.hasNext()) {
				String input = in.next();

				if(input.equals("y") || input.equals("Y"))
					return true;
				else if(input.equals("n") || input.equals("N"))
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

				if(	input.equals("n") || input.equals("N") ||
					input.equals("s") || input.equals("S") ||
					input.equals("q") || input.equals("Q"))
						return input;
				else {
					System.out.println("Illegal input. Try again.");
				}
			}
			in.reset();
		}
	}

	public Boolean players() {
		System.out.println("Do you want to compete to a human player or computer?[H]uman/[C]omputer");
		String input = in.nextLine();

		if(input.)
	}
}