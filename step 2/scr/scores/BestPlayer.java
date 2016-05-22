package scores;
import java.math.*;
import java.io.*;
import java.util.*;


public class BestPlayer {

	private int score;
    private String player;

	public BestPlayer(String name, int theScore){
		this.score=theScore;
		this.player=name;

	}


    /**
    *@return a string "name : score"
    **/
    public String toString(){
        return player + " : " + score;
    }

    public int compareTo (BestPlayer p){
    	if (score<p.score)
    	{
    		return -1;
    	}
    	else if(score==p.score)
    	{
    		return 0;
    	}
    	
        return 1;
    	

    }


}