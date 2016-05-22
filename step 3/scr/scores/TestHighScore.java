package scores;
import java.math.*;
import java.io.*;
import java.util.*;

/**
*Main class.
**/
public class TestHighScore{

    public static void main(String [] argv){

        String playerName = askName();
        String playerScore = askScore();
        BestPlayer p = new BestPlayer(playerName, Integer.parseInt(playerScore));
        BestPlayer[] top10 = HighScore3.tenBestScores(HighScore3.getScores());
        if(top10[9].getScore() < p.getScore()){
            System.out.println("You are in the top10 !");
            HighScore3.sendScore(p);
            top10 = HighScore3.tenBestScores(HighScore3.getScores());
        } else{System.out.println("You are not in the top10..."); }
        for (BestPlayer player : top10){ System.out.println(player.toString());}
    }

	/**
	*readScore ask for a scoreFile and its content as a string.
	*@return The text from a file asked in input.
	**/
    public static String readScore() {
        Scanner keyboard = new Scanner(System.in);
        //While the File isn't open, try again.
        boolean done = false;
        FileInputStream scoreFile = null;
        while (! done) {
            done = true;
            //Asking for the filepath.
            System.out.println("Emplacement du fichier.csv :");
            String filePath ="";
            filePath = keyboard.nextLine();
            //Open the file.
            try{
                scoreFile = new FileInputStream(filePath);
            }
            catch (FileNotFoundException e) {
                done = false;
                System.out.println(e);
            }
        }
        //Get the text into a string
        String fileString = "";
        try {
            int curByte;
            //While we didn't reach the end of the file (read()=-1).
            while ( (curByte=scoreFile.read()) !=-1){
                fileString += (char) curByte;
            }
            //Return here
            scoreFile.close();
        } catch (IOException e) {}
        return fileString;
    }
    
    /**
    *askName, take string standard input and print it.
    *@return String the name asked in input.
    **/
    public static String askName() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What's ur name?");
        String name ="";
        name = keyboard.nextLine();
        return name;
    }
     /**
    *askScore, take string standard input and print it.
    *@return String the Score asked in input.
    **/
    public static String askScore() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What's ur name?");
        String score ="";
        score = keyboard.nextLine();
        return score;
    }
}