package hw6;

import java.util.Queue;

import kwch04.KWQueue;
import kwch04.ListQueue;
import kwch03.ListStack;

public class TestListQueue
{

	/**
	 * Starting code for HW 6.2
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		ListQueue<String> data = new ListQueue<String>();
		
		data = (ListQueue) intQueue(data);//need to pass in a formed Queue since one cannot simply walk into Mordor and initalize an implementation
		//put data into a stack
		System.out.println("Exercise 1 Queue Reversed:");
		reverseQueue(data);
		KWQueue<String> kwData = new KWQueue<String>();
		kwData = (KWQueue) intQueue(kwData);
		System.out.println("Exercise 2 Queue Reversed:");
		reverseQueue(kwData);
		
	}
	
	/**
	 * initalize ListQueue
	 * 
	 * @param 
	 */
	private static Queue<String> intQueue(Queue<String> q){
		String[] initData = {"one","two","three","four","five","six","seven","eight","nine"};
		System.out.print("Initial data: ");
		for (int i=0;i<initData.length;i++)System.out.print(initData[i]+" ");
		System.out.println();
		if (!q.isEmpty()) q.clear();
		for (int i = 0;i<initData.length;i++){
			q.add(initData[i]);
		}//end for
		return q;
	}//end method intQueue
	
	private static void reverseQueue(Queue q){
		ListStack<String> s = new ListStack<String>();
		for (int i =q.size();i>0;i--){
			s.push((String) q.poll());
		}//end for loop
		q.clear();
		while (!s.empty()) q.add(s.pop());
		//Print data to show that queue is backwards
		while (!q.isEmpty())System.out.println(q.poll());
		
	}//end method reverseQueue
}
