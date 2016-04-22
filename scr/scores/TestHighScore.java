package scores;
import java.math.*;

/**
*Class useless for now
**/
public class TestHighScore{
    public static void main(String [] argv){
        String playerName = HighScore1.askName();
        ScoreGrid fakeScores = new ScoreGrid(HighScore1.readScore());
        System.out.println(fakeScores.toString());
        int randomize = (int) ( fakeScores.length() * Math.random() );
        System.out.println(playerName + ": you randomized the " + randomize + " th score " + fakeScores.getXScore(randomize) + ".");
    }
}
