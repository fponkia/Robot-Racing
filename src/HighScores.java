import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 
 */

/**
 * @author Foram Patel
 *Date: 2021-06-04
 *Description: Class which calculates and stores the high-scores of the game.
 *Method List:
 *public static int[] loader(String fileName): Opens file to read
 *public static void storeinFile(int score[], String output): stores information in the file
 *public static int highscores(int count[], String fileName): Counts the highest scores between the players (droids)
 *public static void adding (int score, String fileName): This method adds the highest score of this game to the highest scores of the previous games
 *public static int[] scores (int count[], String fileName): Calculates the scores of all 4 droids.(Steps*2 = player score).
 *
 */
public class HighScores {

	public static int[] loader(String fileName) throws IOException {
		//Opening the file to read
		FileReader fr = new FileReader(fileName);
		BufferedReader input = new BufferedReader(fr);

		int lines [] = new int [5];

		for(int i=0;i<lines.length;i++) {
			lines[i] = Integer.parseInt(input.readLine());
		}

		input.close();//close the file stream
		return lines;//returns the contents of the array
	}

	public static void storeinFile (int score[], String output) throws IOException{
		//Opening a file to write into
		PrintWriter fw = new PrintWriter(new FileWriter(output));

		//Storing highscores of last 5 games in the new file
		for(int i=0;i<score.length;i++) {
			fw.println(score[i]);
		}
		//Closing the file to save
		fw.close();
	}	

	public static int highscores(int count[] , String fileName) throws IOException{
		int score = 0; 
		for(int i=0;i<count.length;i++) { 
			if(count[i]>=score)
				score = count[i];  //store the highest score in a variable
		}
		adding(score , fileName);
		return score;
	}

	public static int[] scores(int count[] , String fileName) throws IOException{
		for(int i = 0;i<count.length;i++) {
			count[i] = count[i] * 2; //store the (steps * 2) which is the score
		}
		highscores(count , fileName);
		return count;
	}

	public static void adding(int score , String fileName) throws IOException {
		int scores[] = new int[5];
		int lines[] = loader(fileName); //load lines from HighScores.txt
		scores[0] = score;
		for(int i=1;i<lines.length;i++) {
			scores[i] =lines[i-1];
		}
		storeinFile(scores, fileName);
	}

	/**
	 * @param args
	 */										
	public static void main(String[] args) throws IOException {

		int output [];

		output = loader("Testing.txt");

		//display the contents of the output array
		for(int i=0;i<output.length;i++) {
			System.out.println(output[i]);

		}
		int array[] = {23,45,65,100};
		scores(array , "Testing.txt");
		
		output = loader("Testing.txt");
		System.out.println("\n Information after adding highscore of last game:");
		//display the contents of the output array
		for(int i=0;i<output.length;i++) {
			System.out.println(output[i]);

		}
	}
}

