package scores;

/**
*Abstract type to manage and sort the scores.
**/
public class ScoreGrid{

    private int length;
    private String[] names;
    private int[] scores;
    
    /**
    *Constructor
    *@param scoreString raw string as score,name\n
    */
    public ScoreGrid(String scoreString){
        //Cut each line, pray to respect the 'score,name\n'.
        String[] getLines = scoreString.split("\n");
        this.length = getLines.length;
        this.names = new String[this.length];
        this.scores = new int[this.length];
        //Put each name and score in their table.
        for (int i = 0; i < this.length; i++){
            this.scores[i] = Integer.parseInt(getLines[i].split(",")[0]);
            this.names[i] = getLines[i].split(",")[1];
        }
    }
    
    public String getXName(int x){
        return "";
    }
    
    public int getXScore(int X){
        return 0;
    }
    
    public void addScore(String name, int score){
        
    }
    
    public void remXScore(int X){
    }
    
    public void cutToN(int n){
        
    }
    
    private void sortScores(){
        
    }
    
    /**
    *Return the grid as 'score,name\n' lines
    */
    public String toString(){
        String toReturn = "";
        //easy loop
        for (int i = 0; i < this.length; i++){
            toReturn += this.scores[i] + "," + this.names[i] + "\n";
        }
        return toReturn;
    }
    
}
