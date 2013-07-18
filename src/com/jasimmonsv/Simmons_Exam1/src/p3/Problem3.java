package p3;

import java.util.InputMismatchException;

import p1.TextIO;
import p2.Term;

/**
* Problem 3 on Take-Home Exam 1
* CSCI 2002-91, Spring 2012
* 
* This depends on interface HighScores. Complete
*   the following code as specified in the Exam 1 handout.
* 
*/

public class Problem3
{
	/**
	 * Tests your HighScoresImpl implementation of HighScores.<br><br>
	 * 
	 *  (you are to complete this method)<br>
	 */
	public static void main(String[] args)
	{
	// ***
	// *** Complete this
	// *** 
		HighScoresImpl highScore = new HighScoresImpl(); //init highScore
		do {
			TextIO.putln("1: Print Scores");
			TextIO.putln("2: Add Score");
			TextIO.putln("3: Print nth Score");
			TextIO.putln("-1: EXIT");
			int choice = TextIO.getlnInt();
			switch (choice) {
			case 1:highScore.print();break;
			case 2:TextIO.putln("Enter score to add: ");
				int score = TextIO.getInt();
				highScore.addScore(score);
				break;
			case 3:TextIO.putln("Which place to view: ");
				int n = TextIO.getInt();
				if (n < 1 || n > 10){
					TextIO.putln("That choice is invalid");
					break;
				}//end if
				TextIO.putln(place(n)+"place score is: "+highScore.nthHighest(n));
				break;					
			case -1:System.exit(0);
			default:break;
			}//end switch
		}while(true);
	}//end method main
	
	private static String place(int n){
		switch (n){
		case 1:return ("1st ");
		case 2:return ("2nd ");
		case 3:return ("3rd ");
		default: return(n+"th ");
		}//end switch
	}//end method place
}
