package kwch04.airlinesim;

import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileReader;
import java.util.Properties;
import java.util.Queue;
import java.util.ArrayDeque;

/**
 * AirlineCheckinSim.java Simulate the checkin process of an airline.
 * 
 * @author Koffman and Wolfgang
 */
public class AirlineCheckinSim
{

	// Data fields

	/** Queue of frequent flyers */
	private PassengerQueue frequentFlyerQueue = new PassengerQueue("Frequent Flyer");

	/** Queue of regular passengers */
	private PassengerQueue regularPassengerQueue = new PassengerQueue("Regular Passenger");
	private final static int MAX_ITER = 40;
	private final static int sampleSize = 50; //size of sample
	private static double[] meanRegWaittime = new double[MAX_ITER];//
	private static double[] meanFFWaittime = new double[MAX_ITER];//
	private static double[] regWaittime = new double[sampleSize]; //holds raw data of  wait times of regular passengers
	private double[] ffWaittime = new double[sampleSize]; //holds raw data of wait times of frequent flier passengers
	private static int iteration =0; //count of iteration ran
	
	
	/**
	 * Maximum number of fequent flyers to be served before a regular passenger
	 * gets served
	 */
	private int frequentFlyerMax;

	/** The maximum time to service a passenger */
	private int maxPocessingTime;

	/** Total simulated time */
	private int totalTime;

	/** If set true, print additional output */
	private boolean showAll;

	/** Simulated clock */
	private int clock = 0;

	/** Time that the agent is done with the current passenger */
	private int timeDone;

	/**
	 * Number of frequent flyiers served since the last regular passenger was
	 * served
	 */
	private int frequentFlyersSinceRP;

	/**
	 * Main method
	 * 
	 * @param args
	 *            optional file name for simulation parameters
	 */
	public static void main(String args[])
	{
		AirlineCheckinSim sim = new AirlineCheckinSim();
		sim.enterData();//enter max service tme
		
		
		//TODO loop runSimulation until best times are found
		
		while (iteration < MAX_ITER-1)
		{
			sim.runSimulation();
			sim.storeStats();//a different method then showStats
			sim.clearQueues();	
			//sim.avgWaittime();
			System.out.println(meanRegWaittime[iteration]+" +-"+sigma(regWaittime));
			sim.incrementQueues();
			iteration++;
		}//end while loop
		System.exit(0);
	}

	/* <exercise chapter="4" section="5" type="programming" number="3"> */

	/** Method to read the simulation parameters */
	private void enterData()
	{
		String reply;

		frequentFlyerQueue.setArrivalRate(1.0 / 60.0);//1 per hour to start with
		regularPassengerQueue.setArrivalRate(1.0 / 60.0);//1 per hour to start with
		frequentFlyerMax = 1;//init 1 freq flyer per reg pass
		totalTime = 120;//120 minutes
		reply = JOptionPane.showInputDialog(null, "Enter the maximim service time in minutes");
		showAll = false;
		System.out.println("Maximum service time in minutes: " + reply);

		maxPocessingTime = Integer.parseInt(reply);

		Passenger.setMaxProcessingTime(maxPocessingTime);
	
	}


	/* </exercise> */

	/** Method to start serving a customer */
	private void startServe()
	{
		if (!frequentFlyerQueue.isEmpty()
				&& ((frequentFlyersSinceRP <= frequentFlyerMax) || regularPassengerQueue.isEmpty()))
		{
			// Serve the next frequent flyer.
			frequentFlyersSinceRP++;
			timeDone = frequentFlyerQueue.update(clock, showAll);
		}
		else if (!regularPassengerQueue.isEmpty())
		{
			// Serve the next regular passenger.
			frequentFlyersSinceRP = 0;
			timeDone = regularPassengerQueue.update(clock, showAll);
		}
		else if (showAll)
		{
			System.out.println("Time is " + clock + ":  Server is idle");
		}
	}

	/** Method to show the statistics. */
	private void showStats()
	{
		System.out.println("\nThe number of regular passengers served was "
				+ regularPassengerQueue.getNumServed());

		double averageWaitingTime = (double) regularPassengerQueue.getTotalWait()
				/ (double) regularPassengerQueue.getNumServed();

		System.out.println(" with an average waiting time of " + averageWaitingTime);

		System.out.println("The number of frequent flyers served was "
				+ frequentFlyerQueue.getNumServed());

		averageWaitingTime = (double) frequentFlyerQueue.getTotalWait()
				/ (double) frequentFlyerQueue.getNumServed();

		System.out.println(" with an average waiting time of " + averageWaitingTime);
		System.out.println("Passengers in frequent flyer queue: " + frequentFlyerQueue.size());
		System.out.println("Passengers in regular queue: " + regularPassengerQueue.size());
		regWaittime[iteration] = averageWaitingTime;

	}
	
	/** Method saves average wait time for regular passengers and ffPassengers
	 * in an array */
	private void storeStats()
	{
		double averageWaitingTime = (double) regularPassengerQueue.getTotalWait() / (double) regularPassengerQueue.getNumServed();
		regWaittime[iteration] = averageWaitingTime;
		

		averageWaitingTime = (double) frequentFlyerQueue.getTotalWait() / (double) frequentFlyerQueue.getNumServed();
		ffWaittime[iteration] = averageWaitingTime;

	}
	
	private void avgWaittime(){
		double sum=0.0;
		for (int i = 0;i< regWaittime.length;i++){
			sum = sum+regWaittime[i];
		}
		sum = sum/regWaittime.length;
		meanRegWaittime[iteration]=sum;
		regWaittime = new double[sampleSize];
		sum=0.0;
		
		for (int i = 0; i<ffWaittime.length;i++){
			sum = sum+ffWaittime[i];
		}
		sum = sum/ffWaittime.length;
		meanFFWaittime[iteration]=sum;
		ffWaittime = new double[sampleSize];
	}//end method avgWaittime

	/** Method to run the simulation */
	private void runSimulation()
	{
		for (this.clock = 0; clock < totalTime; clock++)
		{
			frequentFlyerQueue.checkNewArrival(clock, showAll);
			regularPassengerQueue.checkNewArrival(clock, showAll);

			if (clock >= timeDone)
			{
				startServe();
			}
		}
	}//end method runSimulation

	Queue<int[]> parseArrivalTimes(String arrivalTimesString)
	{
		Queue<int[]> result = new ArrayDeque<int[]>();
		String[] arrivalTimes = arrivalTimesString.trim().split("[\\[\\]]+");

		for (String s : arrivalTimes)
		{
			if (!"".equals(s))
			{
				String[] pair = s.split("\\s+");
				int first = Integer.parseInt(pair[0]);
				int second = Integer.parseInt(pair[1]);
				result.add(new int[] { first, second });
			}
		}
		return result;
	}//end parseArrivialTimes
	
	private void incrementQueues(){
		clearQueues();
		frequentFlyerQueue.setArrivalRate(frequentFlyerQueue.getArrivalRate()+1);
		regularPassengerQueue.setArrivalRate(regularPassengerQueue.getArrivalRate()+1);
		  
	}//end method incrementQueues
	
	private void clearQueues(){
		double ffTime = frequentFlyerQueue.getArrivalRate();
		double rpTime = regularPassengerQueue.getArrivalRate();
		frequentFlyerQueue = new PassengerQueue("Frequent Flyer");
		regularPassengerQueue = new PassengerQueue("Regular Passenger");
		frequentFlyerQueue.setArrivalRate(ffTime);
		regularPassengerQueue.setArrivalRate(rpTime);
		//this.clock = 0;
		this.timeDone = 0;
	}//end method clearQueues
	
	private static String sigma(double[] q){
		double sum = 0.0;
		double var = 0.0;
		double sigma = 0.0;
		for (int i=0;i<q.length;i++)
		{
			var = q[i]-meanRegWaittime[iteration];
			var = var * var;
			sum = sum+var;
		}
		sum = Math.sqrt(1/(q.length-1)*sum);
		return Double.toString(sum);
	}//end method sigma
}
