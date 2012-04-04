package Simmons_HW5;

import java.util.Stack;


/**
 * 1.	Do Programming Exercise 1 in Section 3.2 of our textbook. 
 *		Name your application ReverseWords.  Assume you have only one line of input, 
 *		with a space-delimited * as end-of-input sentinel.
 * @author jasimmonsv
 *
 */
//exercise 1 section 3.2
public class ReverseWords {
	
	public static void main(String[] args) {
		Stack<String> partStack = new Stack<String>();
		
		TextIO.putln("Enter your string: ");
		String sentence = TextIO.getln();
		String parts[] = sentence.split(" ");
		for (int i = 0;i<parts.length;i++)partStack.push(parts[i]);
		TextIO.putln(buildReverse(partStack));
		
	}//end emthod main
	
	private static String buildReverse(Stack<String> parts){
		StringBuilder results = new StringBuilder();
		while (!parts.empty()){
			results.append(parts.pop());
			results.append(" ");
		}//end for
		return results.toString();
		
	}//end method buildReverse

}
