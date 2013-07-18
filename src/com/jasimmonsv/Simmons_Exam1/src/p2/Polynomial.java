package p2;

import java.util.ArrayList;

/**
* Part of Problem 2 on Take-Home Exam 1
* 
* CSCI 2002-91, Spring 2012
* 
* Complete the following code, as specified in the Exam 1 Handout.
* 
*/

public class Polynomial
{
	private ArrayList<Term> terms;
	
	/**
	 * Create empty Polynomial by create new ArrayList<Term>.<br><br>
	 *  
	 */

	public Polynomial ()
	{
	// ***
	// *** Complete this
	// ***
	terms = new ArrayList<Term>();
	}
	
	/**
	 * Add new Term to Polynomial.<br><br>
	 *  
	 */
	
	public void addTerm (Term t)
	{
	// ***
	// *** Complete this
	// ***
	//Find coefficient
	/**for (int i = 0; i < terms.size(); i++){
		if (t.getExp() == terms.get(i).getExp()){
			t = new Term(t.getExp(),t.getCoeff()+terms.get(i).getCoeff());
			break;
		}//end if
	}//end for  
	**/
	terms.add(t);	
	}
	
	/**
	 * Evaluate this Polynomial by substituting passed double 
	 * value for x in each Term.<br><br>
	 * 
	 * That is, if Term represents c*x^e, double c and int e,
	 * then compute c*xValue^e as double, summing over all 
	 * Terms and returning value.
	 *  
	 */

	public double eval (double xValue)
	{
	// ***
	// *** Complete this
	// *** 
		double eval = 0;
		for(int i = 0;i<terms.size();i++){
			double tempEval = 1;
			for (int j = 0;j<terms.get(i).getExp();j++) tempEval = tempEval*xValue;
			tempEval = tempEval*terms.get(i).getCoeff();
			eval = eval + tempEval;
		}//end for
		return eval;
	}//end eval
	
	@Override
	public String toString(){
		String toReturn="0x^0";
		for (int i = 0;i<terms.size();i++){
			toReturn = toReturn+" + "+terms.get(i).toString();
		}//end for
		return toReturn;
	}//end toString
}
