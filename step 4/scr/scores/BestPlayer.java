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

    public String toString(){return (player+" : "+score);}

    public int getScore (){
        return this.score;
    }

    public String getPlayer(){
        return this.player;
    }






}