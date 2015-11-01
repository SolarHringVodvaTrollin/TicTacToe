package is.ru.tictactoe;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveToFile {
	private File playerInfo;
	private File gamesInfo;
	private BufferedWriter outputPlayerInfo;
	private BufferedWriter outputGamesInfo;

	/**
	 *Creates a new instance of a SaveToFile class.
	 *Instantiates the output streams to the files
	 *and the files.
	 */
	public SaveToFile() {
		try {
			playerInfo = new File("playerInfo.txt");
			playerInfo = new File("playerInfo.txt");
			if(!playerInfo.exists()) 
				playerInfo.createNewFile();
	
			gamesInfo = new File("gamesInfo.txt");
			if(!gamesInfo.exists())
				gamesInfo.createNewFile();
			
			FileWriter fwGame = new FileWriter(gamesInfo.getAbsoluteFile(), true);
			FileWriter fwPlayer = new FileWriter(playerInfo.getAbsoluteFile(), true);
			outputGamesInfo = new BufferedWriter(fwGame);
			outputPlayerInfo = new BufferedWriter(fwPlayer);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 *Adds a new player to the playerInfo file.
	 *
	 *@param name of the player and his score
	 */
	public void savePlayerToFile(String name, int score) {
		try {
			String saveToFileString = name + "," + score;
			outputPlayerInfo.write(saveToFileString);
			outputPlayerInfo.newLine();
			outputPlayerInfo.flush();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 *Adds the winner of a match to the gamesInfo file.
	 *
	 *@param name of the player, should be "no winner" if there was no winner
	 */
	public void saveGameToFile(String winner){
		try {
			String saveToFileString = winner;
			outputGamesInfo.write(saveToFileString);
			outputGamesInfo.newLine();
			outputGamesInfo.flush();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 *Closes the output stream to the file
	 */
	public void close(){
		try{
			outputGamesInfo.close();
			outputPlayerInfo.close();
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
}