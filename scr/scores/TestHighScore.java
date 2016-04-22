package scores;

/**
*Class useless for now
**/
public class TestHighScore{
    public static void main(String [] argv){
        HighScore1.askName();
        ScoreGrid fakeScores = new ScoreGrid(HighScore1.readScore());
        System.out.println(fakeScores.toString());
    }
}
