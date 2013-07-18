package p1;

/**
* Problem 1 on Take-Home Exam 1
* 
* CSCI 2002-91, Spring 2012
* 
* Complete the code below and in support class NumberList, as specified
*   in the Exam 1 Handout.
* 
*/

public class Problem1
{
	private static NumberList numList;
	
	/**
	 * Creates new NumberList, then prompts user to enter various-sized int values.<br>
	 * After reading each, put it and its Character actual type indicator in NumberList. <br>
	 * <br>
	 * When user signals no more input, print out each value in NumberList by invoking its<br>
	 *  print() method.
	 *  
	 *  (you are to complete this method)
	 */
	
	public static void main(String[] args)
	{
		numList = new NumberList();
	
	// ***
	// *** Complete the following loop body.
	// ***
	// *** Your code should call readNumber(ch), then add both the returned value
	// ***  and ch to numList.
	// ***
	// *** The input loop should end when the readNumber(char) returns null.
	// ***  You will also need to complete readNumber(char).
	// ***
	// *** Assume that there is enough space in the numList arrays to do this.
	// ***
		
		while (true)
		{
			TextIO.putln("What kind of number do you want to enter?");
			TextIO.putln(" (B=>Byte, S=>Short, I=>Integer, L=>Long, other to quit) ");
			
			char numType = Character.toUpperCase(TextIO.getlnChar());
		// ***
		// *** call readNumber (numType), then add returned Number and numType to numList
		// ***
			if (numType == 'B' || numType == 'S' || numType == 'I' || numType == 'L')
			{
			Number temp = readNumber(numType); //****
			numList.addToList(temp,numType);
			}else break;

		}
		
		numList.print(); // *** you must complete NumberList's print() method.
		
	}//end method Main
	
	/**
	 * Read an integer value and return as Number value, as per char numType:<br>
	 * B=>Byte, S=>Short, I=>Integer, L=>Long<br><br>
	 * 
	 *  
	 *  (you are to complete this method)
	 */
	public static Number readNumber(char numType)
	{
	// ***
	// *** Complete this:
	// ***
	// ***  Prompt, read, create and return the object of the type 
	// ***  Byte, Short, Integer, or Long as specified by numType
	// ***  
	// ***  If numType character is other than B, S, I, or L,
	// ***   return null instead.
	// ***
		
		TextIO.putln("What number do you want to enter?");
		Number tempNum = 0; //****
		switch (numType)
		{
		case 'B':
			tempNum = TextIO.getByte();
			break;
		case 'S':
			tempNum =  TextIO.getShort();
			break;
		case 'I':
			tempNum = TextIO.getInt();
			break;
		case 'L':
			tempNum = TextIO.getLong();
			break;
		default:
			return null;
		}//end switch
		return tempNum;
	}//end method ReadNumber

}//end class
