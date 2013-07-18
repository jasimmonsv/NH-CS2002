package hw6;

import java.util.LinkedList;
import java.util.Queue;

import kwch04.ArrayQueue;

public class DisplayQueue
{

	/**
	 * Starting code for HW 6.1
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		//Implementation 1
		Queue<String> imp1 = new LinkedList<String>();
		imp1.add("Customer1");
		imp1.add("Customer2");
		imp1.add("Customer3");
		imp1.add("Customer4");
		imp1.add("Customer5");
		imp1.add("Customer6");
		printQueue(imp1);
		System.out.println("This should be \"Customer1\" for nonDestruct verification >> "+imp1.peek());
		
		//Implementation 2
		ArrayQueue<String> imp2 = new ArrayQueue<String>();
		imp2.add("1");
		imp2.add("2");
		imp2.add("3");
		imp2.add("4");
		imp2.add("5");
		imp2.add("6");
		printQueue(imp2);
		System.out.println("This should be \"1\" for nonDestruct verification >> "+imp2.peek());
		
	}

	public static void printQueue(Queue<String> q)
	{
		Queue<String> p = new LinkedList<String>();
		while (q.peek() != null)
		{
			String temp = q.poll();
			System.out.println(temp);
			p.add(temp);
		}
		while (p.peek() !=null)
		{
			q.add(p.poll());
		}
	}

}
