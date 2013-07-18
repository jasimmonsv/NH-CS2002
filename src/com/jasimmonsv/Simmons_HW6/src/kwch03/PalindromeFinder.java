/*<listing chapter="3" number="2">*/
package kwch03;

import java.util.Stack;

/**
 * Class with methods to check whether a string is a palindrome.
 * 
 * @author Koffman & Wolfgang
 **/
public class PalindromeFinder
{

	/** String to store in stack. */
	private String inputString;
	/** Stack to hold characters. */
	private Stack<Character> charStack = new Stack<Character>();

	/**
	 * Store the argument string in a stack of characters.
	 * 
	 * @param str
	 *            String of characters to store in the stack
	 */
	public PalindromeFinder(String str)
	{
		inputString = str;
		fillStack();
	}

	/** Method to fill a stack of characters from an input string. */
	private void fillStack()
	{
		for (int i = 0; i < inputString.length(); i++)
		{
			charStack.push(inputString.charAt(i));
		}
	}

	/**
	 * Method to build a string containing the characters in a stack.
	 * 
	 * @post The stack is empty.
	 * @return The string containing the words in the stack
	 */
	private String buildReverse()
	{
		StringBuilder result = new StringBuilder();
		while (!charStack.empty())
		{
			// Remove top item from stack and append it to result.
			result.append(charStack.pop());
		}
		return result.toString();
	}

	public boolean isPalindrome()
	{
		return inputString.equalsIgnoreCase(buildReverse());
	}
}
/* </listing> */
