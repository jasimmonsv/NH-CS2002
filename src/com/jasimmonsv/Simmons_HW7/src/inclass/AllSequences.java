package inclass;


public class AllSequences
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		printSequences (new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g'}, 0, "", 4);
	}
		
	public static void printSequences (char[] elements, int startIndex, String prefix, int length)
	{
		if (length==0)
		{
			TextIO.putln(prefix);
			return;
		}
		
	// make recursive call:  extend prefix by each char in elements[startIndex..], adjusting length
		
	}

}
