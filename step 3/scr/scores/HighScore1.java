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

    public BestPlayer[] tenBestScores(String [] readScores){
        
        BestPlayer[] all= new BestPlayer[readScores.length];

        List<BestPlayer> leadingPlayers = new ArrayList<>();

        for(int i=0; i<readScores.length;i++){
            String[] oneScore = (readScores[i]).split(",");
            all[i]=new BestPlayer(oneScore[3],Integer.parseInt(oneScore[2]));
            
            leadingPlayers.add(all[i]);

        }


        return leadingPlayers.subList(0,10).toArray(new BestPlayer[10]);


        

        }


        public void sendScore(BestPlayer p){
        
                String nom = p.getName();
                int score = p.getPlayer();

                url getURL = new URL("https://api.thingspeak.com/update?api_key=GSY8KGY3OIBH0496&field1="+score+ "&field2="+nom);
                getURL.openStream();


    
}
