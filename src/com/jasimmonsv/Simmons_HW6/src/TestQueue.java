import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Random;

import kwch03.ListStack;
import kwch03.StackInt;
import kwch04.KWQueue;
import kwch04.ListQueue;

/** Program to test a Queue class */
public class TestQueue
{

	public static void main(String[] args)
	{

		KWQueue<String> testQueue = new KWQueue<String>();
		// Queue<Integer> testQueue = new ListQueueReverse<Integer>();
		// Queue<Integer> testQueue = new ArrayQueue<Integer>();
		// Queue<Integer> testQueue = new ArrayQueue2<Integer>();
		KWQueue<String> knownQueue = new KWQueue<String>();
		Random rand = new Random();

		// Fill both queues with 10 random integers
		for (int i = 0; i < 10; i++)
		{
			Integer next = new Integer(rand.nextInt());
			testQueue.offer(next.toString());
			knownQueue.offer(next.toString());
		}
		// See if they both are the same
		verifyQueues(testQueue, knownQueue);

		// Remove 5 items
		for (int i = 0; i < 5; i++)
		{
			testQueue.poll();
			knownQueue.poll();
		}

		// See if they are both the same
		verifyQueues(testQueue, knownQueue);

		// Add 10 more items (forces reallocate of ArrayQueue)
		for (int i = 0; i < 10; i++)
		{
			Integer next = new Integer(rand.nextInt());
			testQueue.offer(next.toString());
			knownQueue.offer(next.toString());
		}

		// See if they are both the same
		verifyQueues(testQueue, knownQueue);
		
		//reverse the queue
		System.out.println("Reverse");
		reverseQueue(knownQueue);
		while (!knownQueue.isEmpty())System.out.println(knownQueue.poll());//print out the queue
		System.out.println("Test finished");
	}

	private static void verifyQueues(Queue<String> q1, Queue<String> q2)
	{
		if (q1.size() != q2.size())
		{
			System.out.printf("Queues different sizes %d %d%n", q1.size(), q2.size());
		}
		for (int i = 0; i < q1.size(); i++)
		{
			String v1 = q1.poll();
			String v2 = q2.poll();
			if (!v1.equals(v2))
			{
				System.out.printf("At index %d q1 is %d and q2 is %d%n", i, v1, v2);
			}
			q1.offer(v1);
			q2.offer(v2);
		}
	}
	
	private static <E> void reverseQueue(Queue<E> q1){
		ListStack temp = new ListStack();
		Object holding = null;
		while(!q1.isEmpty())
			{
			holding = q1.poll();
			System.out.print(holding+" ");
			temp.push(holding);
			//if not printing, this following code would be used instead.
			//temp.push(q1.poll());
			}
		while (!temp.empty())q1.add((E) temp.pop());
		System.out.println("end");
	}//end method reverseQueue
}
