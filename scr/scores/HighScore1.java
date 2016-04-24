package scores;
import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;


/**
*Main class ?
**/

public abstract class HighScore1 {

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
            System.out.println("Emplacement du fichier :");
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
    
    public static String getScore() {
        String resultscore="";
        String ligne=""; 
         BufferedReader br = new BufferedReader(new FileReader("https://api.thingspeak.com/channels/111160/feeds.csv"));
        br.readLine(); /** Pour exclure la première ligne**/
        while (br.readLine()!=null) {
            ligne=br.readLine;
            resultscore+=ligne+"/n";
        }
        return resultscore;
    }
}
