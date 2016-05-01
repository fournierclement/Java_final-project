package scores;
import java.math.*;
import java.io.*;
import java.util.*;

/**
*Class useless for now
**/
public class TestHighScore{

    public static void main(String [] argv){

        String playerName = askName();

        ScoreGrid fakeScores = new ScoreGrid(readScore());
        System.out.println(fakeScores.toString());
        int randomize = (int) ( fakeScores.length() * Math.random() ) + 1;
        System.out.println(playerName + ": you randomized the " + randomize + " th score " + fakeScores.getXScore(randomize) + ".");

        System.out.println(HighScore1.getScore());
    }

	/**
	*readScore ask for a scoreFile and its content as a string.
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
    **/
    public static String askName() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What's ur name?");
        String name ="";
        name = keyboard.nextLine();
        return name;
    }
}