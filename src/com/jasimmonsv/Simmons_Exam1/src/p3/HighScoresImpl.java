package p3;

import java.util.ArrayList;
import p1.TextIO;

/**
* Part of Problem 3 on Take-Home Exam 1
* 
* CSCI 2002-91, Spring 2012
* 
* Finish this class, as specified in the Exam 1 Handout.<br><br>
* 
* See interface HighScores to see what each method should do.
* 
*/

public class HighScoresImpl implements HighScores
{
	private ArrayList<Integer> scores;
	
	public HighScoresImpl()
	{
		scores = new ArrayList<Integer>();
		for (int i = 0;i<10;i++)scores.add(0);
	}
	
	@Override
	public void print()
	{
	// ***
	// *** Complete this
	// ***
	for (int i = 0;i < scores.size();i++) TextIO.putln(place(i+1)+"Place: "+scores.get(i));
	}

	@Override
	public boolean addScore(int score)
	{
	// ***
	// *** Complete this
	// ***
		for (int i = 0;i < scores.size();i++)
			if (score >= scores.get(i)){
				scores.add(i,score);
				scores.remove(10);
				return true;
			}//end if
			return false;
	}

	@Override
	public int nthHighest(int n)
	{
	// ***
	// *** Complete this
	// ***
		return scores.get(n-1);
	}
	
	private static String place(int n){
		switch (n){
		case 1:return ("1st ");
		case 2:return ("2nd ");
		case 3:return ("3rd ");
		default: return(n+"th ");
		}//end switch
	}//end method place

}
