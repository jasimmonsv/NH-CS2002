package kwch04;

import java.util.Stack;
import java.util.Queue;
import java.util.ArrayDeque;

public class Exercise_4_1
{

	public static void main(String[] args)
	{

		/* <exercise chapter="4" section="1" type="programming" number="1"> */
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();
		Queue<Integer> queue = new ArrayDeque<Integer>();

		int[] numbers = { -1, 15, 23, 44, 4, 99 };

		for (int i = 0; i < numbers.length; i++)
		{
			stack1.push(numbers[i]);
			stack2.push(numbers[i]);
		}

		/* </exercise> */

		/* <exercise chapter="4" section="1" type="programming" number="2"> */
		while (!stack1.empty())
		{
			queue.offer(stack1.pop());
		}
		/* </exercise> */

		/* <exercise chapter="4" section="1" type="programming" number="3"> */
		while (!stack2.empty())
		{
			System.out.println(stack2.pop() + "\t" + queue.poll());
		}
		// Expected Output
		// 99 99
		// 4 4
		// 44 44
		// 23 23
		// 15 15
		// -1 -1
		/* </exercise> */
	}
}
