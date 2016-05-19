package scores;
import java.math.*;
import java.io.*;
import java.util.*;


public class BestPlayer {

	private int score;
    private String[] player;

	public BestPlayer(String name, int theScore){
		score=theScore;
		player=name;

	}



    public static int compareTo (BestPlayer p)
    {
    	if (this.score<p.score)
    	{
    		return -1;
    	}
    	else if(this.score==p.score)
    	{
    		return 0;
    	}
    	else(this.score>p.score)
    	{
    		return 1;
    	}
    }

    public int getBestPlayerScore(){
    	return this.score;
    }

     public String getBestPlayerName(){
    	return this.player;
    }

    public void changeScore(int newScore)
    {
    	this.score=newscore;
    }

}