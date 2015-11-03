package is.ru.tictactoe;
import java.util.Scanner;

/**
* This class takes care of the gameplay, prints out the board, gets input from the users
* @author SolarHringVodvaTrollin
* @since 2.11.2015
*/
public class ConsoleUI {
	public ConsoleUI() {
		
	}

/**
* This method draws (prints out to the screen) the numbered grid for the Tic Tac Toe game
*/

	public void draw() {
		System.out.println(" 0 | 1 | 2 ");
		System.out.println(" 3 | 4 | 5 ");
		System.out.println(" 6 | 7 | 8 ");
		System.out.println();
	}

/**
* This method draws (prints out to the screen) the grid and also assigns 'x' when true and 'o' when false to distinguish between two players
*/
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

	/**
	* This method fetches moves from players. The move is an integer.
	* @return if there is a possible move the return statement will return the integer with the index to the squere that was chosen by player, otherwise it returns 0.
	*/

	public int getMove() {
		System.out.println("Enter square: ");
		Scanner in = new Scanner(System.in);

		if(in.hasNextInt()) {
			return in.nextInt();
		}
		return 0;
	}
	
	/**
	* This method gets the name of the first player
	* @param firstPlayerName the name of the first player
	* @return returns the string with the name of the first player
	*/

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

	/**
	* This method gets the name of the second player
	* @param secondPlayerName the name of the second player
	* @return returns the string with the name of the second player
	*/

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

	/**
	* This method gets the input from the player, validates it (checks if it is in range 0-8)
	* @param validInput is a boolean variable that is set to false as default, if the input from user meets the requirements it will be changed to true
	*/

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

	/**
	* This method returns boolean value (true/false) that depends on the input from the user whether he/she wants to continue the game, if so the game will be set to reset.
	*/	

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

	/**
	* This method prints out to the screen message to the player when the move is illegal.
	*/

	public void promptIllegalMove() {
		System.out.println("Illegal move. Is the square already occupied or are you trying to make an out-of-bounds move?");
	}

	/**
	* This method prints out to the screen the name of the winner or the massage that there is a tie
	*/

	public void display(Player winner) {
		if(winner == null) {
			System.out.println("It's a tie!");
		}
		else {
			System.out.println(winner.getName() + "has won!");
		}
	}

	/**
	* This method prints out to the screen the current score
	*/

	public void displayScore(Player p1, Player p2) {
		System.out.println("Current score:");
		System.out.println(p1.getName() + ":\t" + p1.getScore());
		System.out.println(p2.getName() + ":\t" + p2.getScore());
	}

	/**
	* This method prints out to the screen menu for the player to choose from 
	*/

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