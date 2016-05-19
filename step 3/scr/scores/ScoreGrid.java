package scores;

/**
*Abstract type to manage and sort the scores.
**/
public class ScoreGrid{

    private int length;
    private String[] dates;
    private int[] orders;
    private int[] scores;
    private String[] names;
    
    /**
    *Constructor
    *@param scoreString must be a raw string, the first line'll be ignored, the next one shall be 'date,order,score,name\n.
    */
    public ScoreGrid(String scoreString){
        //Cut each line, pray to respect the 'score,name\n'.
        String[] getLines = scoreString.split("\n");
        this.length = getLines.length-1;
        this.dates = new String[this.length];
        this.orders = new int[this.length];
        this.scores = new int[this.length];
        this.names = new String[this.length];
        
        //Put each name and score in their table.
        try{
            for (int i = 0; i < this.length; i++){
                this.dates[i] = getLines[i+1].split(",")[0];
                this.orders[i] = Integer.parseInt(getLines[i+1].split(",")[1]);
                this.scores[i] = Integer.parseInt(getLines[i+1].split(",")[2]);
                this.names[i] = getLines[i+1].split(",")[3];
            }
        } catch (Exception e) {
            System.out.println("Error, are you sure that your lines look like 'date,order,score,name' ?");
            System.exit(-1);
        }
    }
    
    /**
    *Return the current length of the grid.
    *@return length int.
    */
    public int length(){ return this.length ; }
    
    /**
    *Get the xth name of the grid
    *@param x the xth name to pick (from 1).
    *@return a name
    */
    public String getXName(int x){
        if (x < this.length){ return this.names[x-1]; }
        else { return this.names[this.length-1]; }
    }
    
    /**
    *Get the xth score of the grid
    *@param x the xth score to pick (from 1).
    *@return a score
    */
    public int getXScore(int x){
        if (x < this.length){ return this.scores[x-1]; }
        else { return this.scores[this.length-1]; }
    }
    
    /**
    *Not implemented yet.
    **/
    public void addScore(String name, int score){
        
    }
    
    /**
    *Not implemented yet.
    **/
    public void remXScore(int X){
    }

    /**
    *@return the grid as 'date,order,score,name\n' lines
    */
    public String toString(){
        String toReturn = "";
        //easy loop
        for (int i = 0; i < this.length; i++){
            toReturn += this.dates[i] + "," +
                        this.orders[i] + "," +
                        this.scores[i] + "," +
                        this.names[i] + "\n";
        }
        return toReturn;
    }
    
}
