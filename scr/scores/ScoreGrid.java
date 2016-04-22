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
    
    /**
    *Return the current length of the grid.
    */
    public int length(){ return this.length ; }
    
    /**
    *Get the xth name of the grid
    *@param x the xth name to pick (from 1).
    */
    public String getXName(int x){
        if (x < this.length){ return this.names[x-1]; }
        else { return this.names[this.length-1]; }
    }
    
    /**
    *Get the xth score of the grid
    *@param x the xth score to pick (from 1).
    */
    public int getXScore(int x){
        if (x < this.length){ return this.scores[x-1]; }
        else { return this.scores[this.length-1]; }
    }
    
    public void addScore(String name, int score){
        
    }
    
    public void remXScore(int X){
    }
    
    public void cutToN(int n){
        
    }
    
    public void sortScores(){
        
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
