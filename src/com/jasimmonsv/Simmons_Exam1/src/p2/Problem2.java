package p2;

import p1.TextIO;

/**
* Problem 2 on Take-Home Exam 1
* CSCI 2002-91, Spring 2012
* 
* Finish the provided code as specified in the Exam 1 handout.
* 
*/

public class Problem2
{
	/**
	 * Read polynomial p(x), then specific double value v.<br><br>
	 * Evaluate p(v) using Polynomial.eval(double), then print result.<br>
	 * 
	 *  (you are to complete this method)<br>
	 */

	public static void main(String[] args)
	{
	// ***
	// *** Finish this so as specified in the Exam 1 handout
	// ***
		Polynomial poly = readPoly();
		printPoly(poly);
		Double value = readValue();
		TextIO.putln("With x = "+value+" your polunomial evaluates out to "+poly.eval(value));
	}
	
	/**
	 * Read and return new Polynomial p(x), term by term.<br><br>
	 * 
	 *  (you are to complete this method)<br>
	 */

	public static Polynomial readPoly()
	{
		Polynomial toReturn = new Polynomial();
		
		TextIO.putln ("Enter each term of your polynomial with exponents in descending order.");
		TextIO.putln ("When done, enter an exponent of -1 to finish.");
		
		do
		{
			TextIO.putln("Enter your next term:  int exponent first, -1 to end:");
			int exp = TextIO.getlnInt();
			if (exp == -1) return toReturn;
			
			TextIO.putln("Enter the coefficient of your next term:");
			double coeff = TextIO.getlnDouble();
			toReturn.addTerm(new Term(exp,coeff));
		// ***
		// *** Finish this loop, creating and adding a new Term to the Polynomial toReturn
		// ***
		// *** Also handle end-of-loop sentinel entry
		// ***
			
		}
		while (true);
		
	}
	
	public static Double readValue()
	{
		TextIO.putln("Enter a value for x to evaluate:");
		return TextIO.getDouble();

	}//end method readValue
	
	private static void printPoly(Polynomial p){
		TextIO.putln("Your polynomial is:");
		TextIO.putln(p.toString());
	}//end method printPoly

}
