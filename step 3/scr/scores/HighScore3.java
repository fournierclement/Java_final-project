package scores;
import java.io.*;
import java.util.*;
import java.net.*;


/**
*Main class ?
**/

public abstract class HighScore3 {

    /**
    *getScores read our feeds.csv and return it as a string.
    *@return The content of our online feed as a string.
    **/    
    public static String[] getScores() {
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
        return resultScore.split("\n");
    }

    /**
    *tenBestScores get the 10 or less best scores of an Arrray of string.
    *All given score must be positive integers;
    *@param readScores as an array of string with the getScores() synthaxe
    *@return An array of 10 or less BestPlayer objets
    **/
    public static BestPlayer[] tenBestScores(String [] readScores){
        
        BestPlayer[] all= new BestPlayer[readScores.length];

        BestPlayer[] tenBestScores = new BestPlayer[10];

        for(int i=0; i<readScores.length;i++){
            String[] oneScore = (readScores[i]).split(",");
            all[i]=new BestPlayer(oneScore[3],Integer.parseInt(oneScore[2]));
        }

        //for the best 10 (or max lines):
        int rank = 0;
        BestPlayer lesser = new BestPlayer("NONE", 0);
        while (rank < 10){
            tenBestScores[rank] = lesser;
            //look for the biggest of the array
            for (int i = 0; i < all.length ; i++){
                //if all[i] is bigger, continu with it
                if (tenBestScores[rank].compareTo(all[i]) < 0){
                    tenBestScores[rank] = all[i];
                    all[i] = lesser;
                }
            }
            rank++;
        }
        return tenBestScores;
    }
    /**
    *"Post" a new player online
    *@param p a BestPlayer
    *@throws IOException
    **/

    public static void sendScore(BestPlayer p){       
        String nom = p.getPlayer();
        String score = Integer.toString(p.getScore());
        try{
            URL updateURL = new URL("https://api.thingspeak.com/update?api_key=GSY8KGY3OIBH0496&field1="+score+ "&field2="+nom);
            HttpURLConnection connection;
            connection = (HttpURLConnection) updateURL.openConnection();
            connection.setRequestMethod("GET");
            connection.getResponseCode();
        } catch (Exception e) { System.out.println("Error.");}
    }
}
