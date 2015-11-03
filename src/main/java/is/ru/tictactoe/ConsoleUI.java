package is.ru.tictactoe;
import java.util.Scanner;
import java.io.InputStream;
import java.io.OutputStream;

/**
* This class takes care of the gameplay, prints out the board, gets input from the users
* @author SolarHringVodvaTrollin
* @since 2.11.2015
*/
public class ConsoleUI {

	private InputStream systemIn;
	private OutputStream systemOut;

	public ConsoleUI() {
		systemIn = System.in;
		systemOut = System.out;
	}

	public ConsoleUI(InputStream in, OutputStream out) {
		systemIn = in;
		systemOut = out;
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
		Scanner in = new Scanner(systemIn);

		if(in.hasNextInt()) {
			return in.nextInt();
		}
		return -1;
	}

	public void displayTurn(Player player) {
		System.out.print(player.getName() + "'s turn (" + (player.getSymbol() ? "X" : "O") + "). ");
	}
	
	/**
	* This method gets the name of the first player
	* @param firstPlayerName the name of the first player
	* @return returns the string with the name of the first player
	*/
	public String getInputFirstPlayer(){
		Scanner in = new Scanner(systemIn);
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
		Scanner in = new Scanner(systemIn);
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
			Scanner in = new Scanner(systemIn);
			
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
		Scanner in = new Scanner(systemIn);
		System.out.println("Would you like to play another round? [y/n] ");

		if(in.hasNext()) {
			String input = in.next();

			if(input.equals("y") || input.equals("Y"))
				return true;
		}
		return false;
	}

	/**
	* This method prints out to the screen message to the player when the move is illegal.
	*/

	public void promptIllegalMove() {
		System.out.println("Illegal move.");
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
	* This method prints out a prompt
	*/

	public String displayPrompt() {
		System.out.print("$ ");
		Scanner in = new Scanner(systemIn);

		if(in.hasNextLine())
			return in.nextLine();
		else
			return "";
	}

	/**
	 * Displays the help for the user interface
	 * TODO: Implement
	 */
	public void displayHelp() {
		System.out.println("The following commands are available:\n");

		System.out.println("- play human   \t\t\tStarts a new game against a human player.");
		System.out.println("- play computer\t\t\tStarts a new game against a computer player.");
		System.out.println();

		System.out.println("- score\t\t\t\tSee the current score.");
		System.out.println();

		System.out.println("- setname player1 <newname>\tSets the name of player 1 to <newname>.");
		System.out.println("- setname player2 <newname>\tSets the name of player 2 to <newname>.");
		System.out.println();

		System.out.println("- reset\t\t\t\tResets the game (score and player names).");
		System.out.println();

		System.out.println("- quit\t\t\t\tExits the game.");
		System.out.println();

		System.out.println("- help\t\t\t\tDisplays this help screen.");
		System.out.println();
	}

	public void displayWelcome() {
		System.out.println("Welcome to Tic Tac Toe!\n");
		displayHelp();
	}

	public void displayGoodbye() {
		System.out.println("Bye!");
	}

	public void displayReset() {
		System.out.println("The game has been reset.");
	}

	public void confirmNameChange(String newname, String oldname) {
			System.out.println("Name changed from '" + oldname + "' to '" + newname + "'.");
	}

	public Boolean players() {
		System.out.println("Do you want to compete to a human player or computer?[H]uman/[C]omputer");
		
		Scanner in = new Scanner(systemIn);
		
		String input = in.nextLine();
		while(true) {
			if(input.equals("H") || input.equals("h")) {
				return true;
			}
			else if(input.equals("C") || input.equals("c")) {
				return false;
			}
			else {
				System.out.println("Invalid input, please insert eather H for human player or C for computer player.");
			}
		}
	}

	public void invalidArgument(String arg) {
		System.out.println("Invalid argument '" + arg + "'. Type 'help' for help.");
	}

	public void invalidArgument() {
		System.out.println("Invalid argument. Type 'help' for help.");
	}

	public void invalidCommand(String com) {
		System.out.println("Invalid command '" + com + "'. Type 'help' for help.");
	}

	public boolean confirmAction(String action) {
		System.out.println("Are you sure you want to " + action + "?");
		if(action.toLowerCase().equals("reset")) 
			System.out.print("You will lose your score [y/n]: ");
		else if(action.toLowerCase().equals("quit"))
			System.out.print("All data will be lost [y/n]: ");

		Scanner in = new Scanner(systemIn);

		while(in.hasNextLine()) {
			String input = in.nextLine();

			if(input.toLowerCase().startsWith("y"))			return true;
			else if(input.toLowerCase().startsWith("n"))	return false;
		}
		return false;
	}
}