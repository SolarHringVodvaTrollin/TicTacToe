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
* @param board a grid 3x3 for the game
*/
	public static void draw(Board board) {
		System.out.println();
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
	* @return if there is a possible move the return statement will return the integer with the index to the squere that was chosen by player, otherwise it returns -1.
	*/

	public int getMove() {
		System.out.println("Enter square: ");
		Scanner in = new Scanner(systemIn);

		if(in.hasNextInt()) {
			return in.nextInt();
		}
		return -1;
	}


	/**
	* This method prints out to the screen which player´s turn is up
	* @param player An instance of the player
	*/

	public void displayTurn(Player player) {
		System.out.print(player.getName() + "'s turn (" + (player.getSymbol() ? "X" : "O") + "). ");
	}

	/**
	* This method gets the name of the first player
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
	* @return an integer which is an input from the player 
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
	* @return boolean value true if the player wants to play another round or false when the player does not wants to play another turn
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
	* @param winner the player that has won a game
	*/

	public void display(Player winner) {
		if(winner == null) {
			System.out.println("It's a tie!");
		}
		else {
			System.out.println(winner.getName() + " has won!");
		}
	}

	/**
	* This method prints out to the screen the current score
	* @param p1 an instance of the Player1
	* @param p2 an instance of the Player2
	*/

	public void displayScore(Player p1, Player p2) {
		System.out.println("Current score:");
		System.out.println(p1.getName() + ":\t" + p1.getScore());
		System.out.println(p2.getName() + ":\t" + p2.getScore());
	}

	/**
	* This method prints out a prompt
	* @return a string from the player or an empty string when there was no input from the player
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

	/**
	* This method prints to the screen message when the game starts
	*/

	public void displayWelcome() {
		System.out.println("Welcome to Tic Tac Toe!\n");
		displayHelp();
	}

	/**
	* This method prints to the screen message at the end of the game
	*/

	public void displayGoodbye() {
		System.out.println("Bye!");
	}

	/**
	* This method prints to the screen message where the players are informed that the game has been reset
	*/

	public void displayReset() {
		System.out.println("The game has been reset.");
	}

	/**
	* This method displays message that confirms name change
	* @param newname a string input from the user wwhich contains a new name of the player
	* @param oldname a string input from the user wwhich contains an old name of the player
	*/

	public void confirmNameChange(String newname, String oldname) {
			System.out.println("Name changed from '" + oldname + "' to '" + newname + "'.");
	}

	/**
	* This method allows the player to choose hers/his opponent
	* It requires an character input from the player, the letter 'H' for the human opponent or the letter 'C' for the computerAI
	* @return boolean value true when player choses to play agains another human player or false when player choses to play against the computerAI
	*/

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

	/**
	* This method prints out to the screen message to the user that the string input that was entered is invalid.
	* It also suggests to the user the possibility of typing command 'help' for help 
	* @param arg string input that was entered by the user
	*/
	public void invalidArgument(String arg) {
		System.out.println("Invalid argument '" + arg + "'. Type 'help' for help.");
	}

	/**
	* This method prints out to the screen message to the user that the argument is invalid.
	* It also suggests to the user the possibility of typing command 'help' for help 
	*/

	public void invalidArgument() {
		System.out.println("Invalid argument. Type 'help' for help.");
	}

	/**
	* This method prints out to the screen message to the user that the command that was entered is invalid.
	* It also suggests to the user the possibility of typing command 'help' for help 
	* @param com command that was entered by the user
	*/

	public void invalidCommand(String com) {
		System.out.println("Invalid command '" + com + "'. Type 'help' for help.");
	}

	/**
	* This method propmts from the player a confirmation (boolean answer: yes or no) before performing an action, gives him/her a warning if their action causes some changes to the game
	* @param action a string from the user with an action that user wishes to perform
	* @return boolean value true when player confirms his/hers action, or false when player cancels his/hers action
	*/

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