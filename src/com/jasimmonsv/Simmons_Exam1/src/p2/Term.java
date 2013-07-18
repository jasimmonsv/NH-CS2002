package p2;

/**
* Part of Problem 2 on Take-Home Exam 1
* 
* CSCI 2002-91, Spring 2012
* 
* Modify the following code if you wish, as specified in the Exam 1 Handout.
* 
*/

public class Term
{
	private int exponent;
	private double coefficient;
	
	/**
	 * Create Term with given exponent and coefficient<br><br>
	 *  
	 */

	public Term (int exp, double coeff)
	{
		this.exponent = exp;
		this.coefficient = coeff;
	}//end constructor
	
	public double getCoeff(){
		return this.coefficient;
	}
	
	public int getExp(){
		return this.exponent;
	}
	
	@Override
	public String toString(){
		return coefficient+"x^"+exponent;
	}//end method toString
	
}
