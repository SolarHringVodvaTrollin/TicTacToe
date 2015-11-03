package is.ru.tictactoe;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class SaveToFile {
	private File playerInfo;
	private File gamesInfo;
	private BufferedWriter outputPlayerInfo;
	private BufferedWriter outputGamesInfo;
	private BufferedReader inputPlayerInfo;
	//private BufferedReader inputGamesInfo;

	/**
	 *Creates a new instance of a SaveToFile class.
	 *Instantiates the output streams to the files
	 *and from the files.
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
			//FileReader frGame = new FileReader(gamesInfo.getAbsoluteFile());
			FileReader frPlayer = new FileReader(playerInfo.getAbsoluteFile());
			outputGamesInfo = new BufferedWriter(fwGame);
			outputPlayerInfo = new BufferedWriter(fwPlayer);
			//inputGamesInfo = new BufferedReader(frGame);
			inputPlayerInfo = new BufferedReader(frPlayer);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 *Adds a new player to the playerInfo file.
	 *@param name of the player to be saved
	 *@param score of the player
	 *
	 */
	public void savePlayerToFile(String name, int score) {
		try {
			String line = null;

			while((line = inputPlayerInfo.readLine()) != null) {

				if(line.contains(name))
				{
					return;
				}
			}
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
	//TODO add upadating feature so playerInfo file gets updated when set player wins.
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

	public void updatePlayerScore(String name) {
		File tempFile = new File("file.txt");
		tempFile.createNewFile();
		FileWriter fwTemp = new FileWriter(tempFile.getAbsoluteFile());
		BufferedWriter outputTemp = new BufferedWriter(fwTemp);

		String line = null;

		while((line = inputPlayerInfo.readLine()) != null) {

			if(line.contains(name))
			{
				String[] splitString = line.split(",");
				int incrementNumber = Integer.parseInt(splitString[1]);
				incrementNumber++;
				line = name + "," + incrementNumber;
			}
			outputTemp.write(line);
			outputTemp.flush();
		}
		output.close();

		if(!playerInfo.delete()){
			System.out.println("coudlnt delete file");
		}
		tempFile.renameTo(playerInfo);
		playerInfo = tempFile;
	}*/
	
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