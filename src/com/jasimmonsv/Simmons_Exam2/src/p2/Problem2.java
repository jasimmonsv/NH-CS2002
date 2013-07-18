package p2;

import java.util.Stack;

import p1.StackImpl;

public class Problem2
{

	/**
	 * Starting code for Problem 2 of Take-Home Exam 2.
	 * 
	 * Complete implementation of isBalanced(String),
	 *  which should return true exactly when passed argument
	 *  has balanced parentheses (as defined in the Exam handout).
	 *  
	 * Then complete Problem2.main(..) so it tests your implementation.
	 * 
	 */
	public static void main(String[] args)
	{
		//get the input
		System.out.println("Awaiting input string: ");
		String str = TextIO.getln();
		//print out the results
		if(isBalanced(str))System.out.println("There are balanced parentheses in this string:");
		else{System.out.println("There is an unbalanced parenthese in this string:");}
		System.out.println(str);
	}
	
	public static boolean isBalanced (String s)
	{
		boolean flag=true;
		Stack<Character> check = new Stack<Character>();
		//convert string into a stack
		for (int i =0;i<s.length();i++){
			check.push(s.charAt(i));
		}//end for
		
		while (!check.isEmpty()){
			boolean temp = findRight(check);
			flag= flag && temp;//is there a way to force Java to re-evaluate the findRight(check) function if I add it here instead?
		}//end while
				
		return flag;
		//TODO match up parentheses
		//Need to check for ( code
		
		
	}//end method isBalanced
	
	private static boolean findRight(Stack<Character> check){
		Character temp = null;
		while (!check.isEmpty()){
			temp = check.pop();
			if(temp==')') {
				return findLeft(check);
			}
			else if (temp=='('){
				return false;
			}//end else
		}//end while
		return false;
	}//end method checkPar
	
	private static boolean findLeft(Stack<Character> check){
		Character temp = null;
		while (!check.isEmpty()){
			temp = check.pop();
			if(temp==')') return findLeft(check);
			else if(temp=='(')return true;
		}//end while
		return false;
	}//end method findLeft

}
