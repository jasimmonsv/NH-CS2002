package kwch03;

import java.util.Stack;

public class Exercise_3_1
{

	public static void main(String[] args)
	{

		/* <exercise chapter="3" section="1" type="programming" number="1"> */
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();
		Stack<Integer> stack3 = new Stack<Integer>();

		int[] numbers = { -1, 15, 23, 44, 4, 99 };

		for (int i = 0; i < numbers.length; i++)
		{
			stack1.push(numbers[i]);
			stack2.push(numbers[i]);
		}

		/* </exercise> */

		/* <exercise chapter="3" section="1" type="programming" number="2"> */
		while (!stack1.empty())
		{
			stack3.push(stack1.pop());
		}
		/* </exercise> */

		/* <exercise chapter="3" section="1" type="programming" number="3"> */
		while (!stack2.empty())
		{
			System.out.println(stack2.pop() + "\t" + stack3.pop());
		}
		/*
		 * Expected Output 99 -1 4 15 44 23 23 44 15 4 -1 99
		 */
		/* </exercise> */
	}
}
