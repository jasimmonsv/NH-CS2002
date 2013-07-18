package p1;

public class Problem1
{

	/**
	 * Starting code for Problem 1, Take-Home Exam 2
	 * 
	 * Finish the provided mergeSorted (Stack, Stack) method,
	 *  so it merges both Stack arguments into a single sorted Stack.
	 *  
	 * Then implement Problem1.main(..) so it demonstrates the
	 *  correct behavior of your method implementation.
	 *  
	 * You must use the provided implementation of the Stack interface,
	 *  as well as test using your completed version of the StackImpl
	 *  class which implements this interface.
	 *  
	 */
	public static void main(String[] args)
	{
		//**Declare needed variables
		//Original Ganster stacks
		StackImpl stack1 = new StackImpl();
		StackImpl stack2 = new StackImpl();
		//test data is backwards to simulate a sorted stack
		int[] testData2 = {5,4,3,2,1};
		int[] testData = {10,9,8,7,6};
		
		//add test data into the stacks
		for (int i = 0;i<testData.length;i++){
			stack1.push(testData[i]);
			stack2.push(testData2[i]);
		}//end for
		
		//The magic****************
		StackImpl finalStack = (StackImpl) mergeSorted(stack1,stack2);
		//Print out the results for peer review (Secretly I just want approval)
		System.out.println("Results: ");
		while (!finalStack.isEmpty())System.out.print(finalStack.pop()+" ");
		System.out.println("...Done!");
	}
	
	public static Stack mergeSorted (Stack s1, Stack s2)
	{
		//holds peek values of stacks
		int temp1 = 0;
		int temp2 = 0;
		//to hold flipped stacks
		StackImpl tempStack = new StackImpl();
		StackImpl tempStack2 = new StackImpl();
		StackImpl s3 = new StackImpl();
		
		//"peek" into the stacks to see which needs to be merged first
		temp2 = s2.pop(); 
		temp1 = s1.pop();
		//figure out which stack is larger and flip that sh!t
		if(temp2>temp1){
			tempStack = flippinStacks(s2);
			tempStack2 = flippinStacks(s1);
		}//end if
		else{
			tempStack = flippinStacks(s1);
			tempStack2 = flippinStacks(s2);
		}//end else
		
		//push the first stacks onto final output
		while(!tempStack.isEmpty()){
			s3.push(tempStack.pop());
		}
		//don't forget to add in the peek output
		if(temp1>temp2)s3.push(temp1);
			else{s3.push(temp2);}
		
		//add second stack onto final output
		while(!tempStack2.isEmpty()){
			s3.push(tempStack2.pop());
		}
		//dont forget to add the peek output
		if(temp1>temp2)s3.push(temp2);
		else{s3.push(temp1);}
		return s3;
	}//end method mergedSorted
	
	/**
	 * 
	 * @param s1 stack to flip
	 * @return flipped stack to remain ordered when pushed onto new stack
	 */
	private static StackImpl flippinStacks(Stack s1){
		StackImpl temp = new StackImpl();
		while (!s1.isEmpty()) temp.push(s1.pop());
		return temp;
	}//end method flippinStacks

	
}
