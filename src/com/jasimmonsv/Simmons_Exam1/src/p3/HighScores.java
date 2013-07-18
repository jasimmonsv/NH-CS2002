package p3;

/**
 * Part of Problem 3 on Take-Home Exam 1
 * 
 * CSCI 2002-91, Spring 2012
 * 
 * Interface for manipulating "high score" storage.
 * 
 */

public interface HighScores
{
	
	/**
	 * Print out each score on separate line,
	 * highest to lowest.
	 *  
	 */

	void print();

	/**
	 * Return nth highest score, 1<=n<=10.  1=> highest score,
	 * 2 => second highest, etc... with 10 => tenth highest.
	 *   
	 */

	int nthHighest(int n);

	/**
	 * Add score to top-ten list.  If score is "new" top-ten value,
	 * remove lowest of previous top-ten, then add score, and return true<br><br>
	 * 
	 * If score is not among top ten, do nothing and return false.
	 *  
	 */

	boolean addScore(int score);

}
