package com.jasimmonsv.Simmons_HW5;
import java.util.*;

import javax.swing.JOptionPane;

public class InfixToPostfix2{
	

//Data fileds
private Stack<Character> operatorStack;
private static final String OPERATORS = "+-^*/";
private static final int[] PRECEDENCE = {1,1,1,2,2};
private StringBuilder postfix;

/**
 * @param infix The infex expression
 * @throws SyntaxErrorException 
 */
public static void main(String args[]){
	InfixToPostfix2 inToPost = new InfixToPostfix2();
	String infix = JOptionPane.showInputDialog("Enter an infix expression");
	try{
		String postfix = inToPost.convert(infix);
		JOptionPane.showMessageDialog(null,"Infix expression "+infix+"\nconverts to "+postfix);
	}catch(SyntaxErrorException e){
		JOptionPane.showMessageDialog(null, e.getMessage());
	}//end catch
	System.exit(0);
}//end method main

public String convert(String infix) throws SyntaxErrorException {
	operatorStack = new Stack<Character>();
	postfix = new StringBuilder();
	String[] tokens = infix.split("\\s+");
	try{
		//Process each token in the infix string.
		for (String nextToken : tokens){
			char firstChar = nextToken.charAt(0);
			//is it an operand?
			if (Character.isJavaIdentifierStart(firstChar) || Character.isDigit(firstChar)){
				postfix.append(nextToken);
				postfix.append(' ');
			}//is it an operator?
			else if(isOperator(firstChar)){
				processOperator(firstChar);
			}//end else
			else {
				throw new SyntaxErrorException ("Unexpected Character Encounted: " + firstChar);
			}//end else
		}//end loop
		
		//pop any remaining operators and append them to postfix
		while (!operatorStack.empty()){
			char op = operatorStack.pop();
			postfix.append(op);
			postfix.append(' ');
		}//end while
		//assert: Stack is empty, return result
		return postfix.toString();
	} catch (EmptyStackException ex){
		throw new SyntaxErrorException ("Syntax Error: The stack is empty");
	}//end catch
}//end method convert

/** Method to process operators.
 * @param op The operator
 * @throws EmptyStackException
 */
private void processOperator(char op){
	if(operatorStack.empty()){
		operatorStack.push(op);
	} else {
		//Peek the operator stack and let topOp be top operator
		char topOp = operatorStack.peek();
		if (precedence(op) > precedence(topOp)){
			operatorStack.push(op);
		} else {
			//Pop all stacked operators with equal or higher precedence than op
			while (!operatorStack.empty() && precedence(op) <= precedence(topOp)){
				operatorStack.pop();
				postfix.append(topOp);
				postfix.append(' ');
				if (!operatorStack.empty()){
					//Reset topOp.
					topOp = operatorStack.peek();
				}//end if
			}//end while
			//assert: operator stack it empty or current operator precedence > top of stack operator precedence.
			operatorStack.push(op);
		}//end else
	}//end else
}//end method processOperator

/** Determine wethe a character is an operator.
 * @param ch The character to be tested
 * @return true if ch is an operator
 */
private boolean isOperator(char ch){
	return OPERATORS.indexOf(ch) != -1;
}//end emthod isOperator

/**Determine the precedence of an operator.
 * @param op The operator
 * @return the precedence
 */
private int precedence(char op){
	return PRECEDENCE[OPERATORS.indexOf(op)];
}//end method precedence

//Nested Class
/** Class to report a syntax error */
public static class SyntaxErrorException extends Exception{
	/** Construc a SyntaxErrorException with the specified message.
	 * @param message The message
	 */
	SyntaxErrorException(String message){
		super(message);
	}//end constructor
}//end nested class SyntaxErrorException
}//end class InFixToPostfix