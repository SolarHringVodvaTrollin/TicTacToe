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

	public void savePlayerToFile(String name, int score) {
		try {
			String saveToFileString = name + "," + score;
			outputPlayerInfo.write(saveToFileString);
			outputPlayerInfo.newLine();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void saveGameToFile(String winner){
		try {
			String saveToFileString = winner;
			outputGamesInfo.write(saveToFileString);
			outputGamesInfo.newLine();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
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