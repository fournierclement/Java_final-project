package scores;
import java.io.*;
import java.util.*;


/**
*Main class ?
**/

public class TestHighScore1 {

    public static void main(String [] args) {
        askName();
        readScores();
    }

    public static void readScores() {
        Scanner keyboard = new Scanner(System.in);
        //While the File isn't open, try again.
        boolean done = false;
        FileInputStream scoreFile = null;
        while (! done) {
            done = true;
            //Asking for the filepath.
            System.out.println("Emplacement du fichier :\n");
            String filePath ="";
            //while (keyboard.hasNextLine()){
                filePath = keyboard.nextLine();
            //}
            //Open the file.
            try{
                scoreFile = new FileInputStream(new File(filePath));
            }
            catch (FileNotFoundException e) {
                done = false;
                System.out.println(e);
            }
        }
        try {scoreFile.close();} catch (IOException e) {}
        
        //keyboard.close();
    }
    
    public static void askName() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What's ur name?");
        String name ="";
        //while (!keyboard.hasNextLine()){
            name = keyboard.nextLine();
        //}
        System.out.println(name);
    }
}
