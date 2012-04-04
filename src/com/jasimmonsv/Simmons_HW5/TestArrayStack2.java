package com.jasimmonsv.Simmons_HW5;

import java.util.EmptyStackException;

/**
 * 2.	Do Programming Exercise 2 in Section 3.3 of our textbook. 
 *		Name your completed class ArrayStack2<E>. Test it by creating an application TestArrayStack2 
 *		that creates several ArrayStack2<E> objects, using at least two different E types.  
 *		Then demonstrate the use of each method within ArrayStack2<E> in your code, in whatever way you wish.
 */
//** Section 3.3 Exercise 2

public class TestArrayStack2 {
	
	public static void main(String[] args){
		int[] testData1 = {1,2,3,4,5,6,7,8,9,10};
		int[] testData2 = {11,12,13,14,15,16,17,18,19,20};
		int[] testData3 = {21,22,23,24,25,26,27,28,29,30};
		char[] alphaData1 = {'a','b','c','d','e','f','g','h','i','j'};
		char[] alphaData2 = {'k','l','m','n','o','p','q','r','s','t'};
		ArrayStack2 test1 = new ArrayStack2();
		ArrayStack2 test2 = new ArrayStack2();
		
	//empty
		System.out.println("    <Empty function>");
		System.out.println("Expecting true=> "+test1.empty());
		try{
			test1.peek();
		}catch(EmptyStackException e){
			System.out.println("Caught Peek Error: "+e);
		}
		try{
			test1.pop();
		}catch(EmptyStackException e){
			System.out.println("Caught Pop Error: "+e);
		}
	//push
		System.out.println("    <Push function>");
		System.out.print("Pushing...");
		for (int i = 0;i<10;i++){
			System.out.print(testData1[i]+", ");test1.push(testData1[i]);
			test2.push(alphaData1[i]);
		}
		System.out.println("\nExpecting false=> "+test1.empty());
	//peek
		System.out.println("    <Peek function>");
		System.out.println("Expecting 10=> "+test1.peek());
		System.out.println("Expecting 10=> "+test1.peek());
	//pop
		System.out.println("    <Pop function>");
		System.out.println("Expecting 10=> "+test1.pop());
		System.out.println("Expecting 9=> "+test1.pop());
	
	
	//reallocate
		System.out.println("<Reallocate function>");
		try{
			for (int i = 0;i<10;i++){
				System.out.print(testData2[i]+", ");test1.push(testData2[i]);
			}//end for
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Caught error: "+ e);
		}//end catch
		try{
			for (int i = 0;i<10;i++){
				test2.push(alphaData2[i]);
			}//end for
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Caught error: "+ e);
		}//end catch
	//print entire stack
		System.out.println("\nPrinting entire stack:");
		try{
			while(true)System.out.print(test1.pop()+" ");
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("End of Stack");
		}//end catch
		System.out.println("\nPrinting Alpha stack:");
		try{
			while(true)System.out.print(test2.pop()+" ");
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("End of Stack");
		}//end catch
	}//end method main

	
}
