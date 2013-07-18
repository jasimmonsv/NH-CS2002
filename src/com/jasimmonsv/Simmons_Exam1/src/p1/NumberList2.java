package p1;

/**
 * Part of Problem 2 on Take-Home Exam 1 
 * 
 * CSCI 2002-91, Spring 2012
 * 
 * Complete the code below as requested in the comments.
 * 
 * But...
 * 
 **** You may NOT add any additional fields to the ones provided below, nor change
 * them.
 * 
 **** You may NOT add any additional classes to those provided (Problem1 and
 * NumberList).
 * 
 **** You may NOT use any explicit cast operator (type) anywhere in your code, in
 * either class.
 * 
 * Beyond this, add methods if you wish, or modify provided code except as
 * constrained above.
 * 
 * @author eric
 * 
 */
public class NumberList2
{
	/**
	 * Number[] array to store values.
	 * 
	 * Each is 
	 */
	private Number[] numList;
	private int count;

	/**
	 * Create Number[] and Character[] arrays of length 100,
	 *  to hold values and one-char actual types of values.<br><br>
	 *  
	 *  count is the current number of values stored<br>
	 */
	public NumberList2()
	{
		this.numList = new Number[100];
		this.count = 0;
	}

	/**
	 * Add the Number num and its actual type Character ctype to list.<br><br>
	 *  
	 *  (you are to complete this method)
	 */
	public void addToList(Number num)
	{
		// *** Complete this, so that num and ctype are placed at the
		// *** end of the current values in numList and typeList, respectively.
		// ***
		// *** Assume there's enough space in the arrays.

		this.numList[this.count] = num;
		count++;
		
	}
	
	/**
	 * Print out each value in list to console, one per line in format:.<br><br>
	 * nnnn (T)
	 *  where nnn is value of Number, T its type as follows:<br>
	 *    B => Byte <br>
	 *    S => Short <br>
	 *    I => Integer <br>
	 *    L => Long <br>
	 *  
	 *  (you are to complete this method)
	 */
	public void print()
	{
		// ***
		// *** Complete this, so that each value in numList is printed to the
		// console,
		// *** one per line, in the format:
		// ***
		// *** #### (T)
		// ***
		// *** where #### is the numeric value found in numList, and T is the
		// type
		// *** character (B,S,I,L) found in the corresponding place in ctypeList
		// ***
		// *** Assume there's enough space in the arrays.
		// ***
		//this.numList[i].getClass()
		for (int i = 0;i<this.count;i++) 
			System.out.println(this.numList[i].toString()+" ("+returnType(this.numList[i].getClass())+")");

	}//end method print
	
	private char returnType(Class o){
		
			if (o.getClass().equals(Integer.TYPE)) return 'I';
			else if (o.getClass().equals(Long.TYPE)) return 'L';
			else if (o.getClass().equals(Short.TYPE)) return 'S';
			else if (o.getClass().equals(Byte.TYPE)) return 'B';
			else return 'x';
	}//end method char

}
