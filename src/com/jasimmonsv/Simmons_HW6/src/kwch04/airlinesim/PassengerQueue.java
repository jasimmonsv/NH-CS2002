package kwch04.airlinesim;

import java.util.Queue;
import java.util.LinkedList;

/**
 * Class to simulate a queue of passengers.
 * 
 * @author Koffman & Wolfgang
 * */
public class PassengerQueue
{
	// Data Fields

	/** The queue of passengers. */
	private Queue<Passenger> theQueue;
	/** The number of passengers served. */
	private int numServed;
	/** The total time passengers were waiting. */
	private int totalWait;
	/** The name of this queue. */
	private String queueName;
	/** The average arrival rate. */
	private double arrivalRate;
	/** The list of pre-defined arrival times and processing times */
	Queue<int[]> arrivalTimes = null;

	// Constructor
	/**
	 * Construct a PassengerQueue with the given name.
	 * 
	 * @param queueName
	 *            The name of this queue
	 */
	public PassengerQueue(String queueName)
	{
		numServed = 0;
		totalWait = 0;
		this.queueName = queueName;
		theQueue = new LinkedList<Passenger>();
	}

	/**
	 * Construct a PassengerQueue with the given name and a pre-defined sequence
	 * of arrival times.
	 * 
	 * @param queueName
	 *            The name of this queue
	 * @param arrivalTimes
	 *            A Queue<int[]> of arrival and processing times
	 */
	public PassengerQueue(String queueName, Queue<int[]> arrivalTimes)
	{
		this(queueName);
		this.arrivalTimes = arrivalTimes;
	}

	/**
	 * Return the number of passengers served
	 * 
	 * @return The number of passengers served
	 */
	public int getNumServed()
	{
		return numServed;
	}

	/**
	 * Return the total wait time
	 * 
	 * @return The total wait time
	 */
	public int getTotalWait()
	{
		return totalWait;
	}

	/**
	 * Return the queue name
	 * 
	 * @return - The queu name
	 */
	public String getQueueName()
	{
		return queueName;
	}

	/**
	 * Set the arrival rate
	 * 
	 * @param arrivalRate
	 *            the value to set
	 */
	public void setArrivalRate(double arrivalRate)
	{
		this.arrivalRate = arrivalRate;
	}

	/**
	 * Get the arrival rate
	 * 
	 * @return the arrival rate
	 */
	public double getArrivalRate()
	{
		return arrivalRate;
	}

	/**
	 * Determine if the passenger queue is empty
	 * 
	 * @return true if the passenger queue is empty
	 */
	public boolean isEmpty()
	{
		return theQueue.isEmpty();
	}

	/**
	 * Determine the size of the passenger queue
	 * 
	 * @return the size of the passenger queue
	 */
	public int size()
	{
		return theQueue.size();
	}

	/**
	 * Check if a new arrival has occurred.
	 * 
	 * @param clock
	 *            The current simulated time
	 * @param showAll
	 *            Flag to indicate that detailed data should be output
	 */
	public void checkNewArrival(int clock, boolean showAll)
	{
		if (arrivalTimes != null && !arrivalTimes.isEmpty())
		{
			int[] nextArrivalTime = arrivalTimes.peek();
			if (clock == nextArrivalTime[0])
			{
				theQueue.add(new Passenger(clock, nextArrivalTime[1]));
				if (showAll)
				{
					System.out.println("Time is " + clock + ": " + queueName
							+ " arrival, new queue size is " + theQueue.size());
				}
				arrivalTimes.poll();
			}
		}
		else
		{
			if (Math.random() < arrivalRate)
			{
				theQueue.add(new Passenger(clock));
				if (showAll)
				{
					System.out.println("Time is " + clock + ": " + queueName
							+ " arrival, new queue size is " + theQueue.size());
				}
			}
		}
	}

	/**
	 * Update statistics.
	 * 
	 * @pre The queue is not empty.
	 * @param clock
	 *            The current simulated time
	 * @param showAll
	 *            Flag to indicate whether to show detail
	 * @return Time passenger is done being served
	 */
	public int update(int clock, boolean showAll)
	{
		Passenger nextPassenger = theQueue.remove();
		int timeStamp = nextPassenger.getArrivalTime();
		int wait = clock - timeStamp;
		totalWait += wait;
		numServed++;
		if (showAll)
		{
			System.out.println("Time is " + clock + ": Serving " + queueName + " with time stamp "
					+ timeStamp);
		}
		return clock + nextPassenger.getProcessingTime();
	}
}
