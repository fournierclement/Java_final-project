package scores;
import java.io.*;
import java.util.*;
import java.net.*;


/**
*Main class ?
**/

public abstract class HighScore1 {

    /**
    *getScore read our feeds.csv and return it as a string.
    *@return The content of our online feed as a string.
    **/    
    public static String getScore() {
        String resultScore="";

        try {
            //Open the connection
            BufferedReader br = new BufferedReader(new InputStreamReader(
                new URL("https://api.thingspeak.com/channels/111160/feeds.csv").openStream()));
            br.readLine(); // Pour exclure la première ligne
            /*
            while (br.readLine()!="null") {
            Each time you use readLine(), you pass to the next line, even in a test
            Better do : */
            String line;
            while( (line=br.readLine()) != null){
                //Like this, you can keep the line you just tested.
                resultScore+= line + "\n";
            }
        } catch (Exception e) { System.out.println("Error.");}
        return resultScore;
    }
}
