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
public class AirlineCheckinSim2
{

	// Data fields

	/** Queue of frequent flyers */
	private PassengerQueue frequentFlyerQueue = new PassengerQueue("Frequent Flyer");

	/** Queue of regular passengers */
	private PassengerQueue regularPassengerQueue = new PassengerQueue("Regular Passenger");

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
		AirlineCheckinSim2 sim = new AirlineCheckinSim2();

		if (args.length > 0)
		{
			sim.enterData(args[0]);
		}
		else
		{
			sim.enterData();
		}
		
		sim.runSimulation();
		sim.showStats();
		System.exit(0);
	}

	/* <exercise chapter="4" section="5" type="programming" number="3"> */

	/** Method to read the simulation parameters */
	private void enterData()
	{
		String reply;

		reply = JOptionPane.showInputDialog(null,
				"Expected number of frequent flyer arrivals per hour:");

		System.out.println("Expected number of frequent flyer arrivals per hour: " + reply);

		frequentFlyerQueue.setArrivalRate(Double.parseDouble(reply) / 60.0);

		reply = JOptionPane.showInputDialog(null,
				"Expected number of regular passenger arrivals per hour:");

		System.out.println("Expected number of regular passenger arrivals per hour: " + reply);
		regularPassengerQueue.setArrivalRate(Double.parseDouble(reply) / 60.0);

		reply = JOptionPane.showInputDialog(null, "Enter the maximum number of frequent flyers"
				+ "\nserved between regualr passengers");

		System.out.println("The maximum number of frequent flyers"
				+ "\nserved between regualar passengers: " + reply);

		frequentFlyerMax = Integer.parseInt(reply);

		reply = JOptionPane.showInputDialog(null, "Enter the maximim service time in minutes");

		System.out.println("Maximum service time in minutes: " + reply);

		maxPocessingTime = Integer.parseInt(reply);

		Passenger.setMaxProcessingTime(maxPocessingTime);

		reply = JOptionPane.showInputDialog(null, "Enter the total simulation time in minutes");

		System.out.println("The total simulation time in minutes: " + reply);

		totalTime = Integer.parseInt(reply);

		reply = JOptionPane.showInputDialog(null,
				"Display minute-by-minute trace of simulation (Y or N)");

		System.out.println("Display minute-by-minute trace of simulation (Y or N): " + reply);

		showAll = (reply.charAt(0) == 'Y') || (reply.charAt(0) == 'y');

		/* <exercise chapter="4" section="5" type="programming" number="2"> */
		reply = JOptionPane.showInputDialog(null, "Set simulation granularity to seconds (Y or N)");

		System.out.println("Set simulation granularity to seconds (Y or N): " + reply);

		if ((reply.charAt(0) == 'Y') || (reply.charAt(0) == 'y'))
		{
			frequentFlyerQueue.setArrivalRate(frequentFlyerQueue.getArrivalRate() / 60.0);
			regularPassengerQueue.setArrivalRate(regularPassengerQueue.getArrivalRate() / 60.0);
			Passenger.setMaxProcessingTime(Passenger.getMaxProcessingTime() * 60);
			totalTime *= 60;
		}
		/* </exercise> */
	}

	public void enterData(String fileName)
	{
		try
		{
			Properties p = new Properties();

			p.load(new FileReader(new File(fileName)));

			String ffArrivals = p.getProperty("frequentFlyerArrivals");

			if (ffArrivals != null)
			{
				Queue<int[]> frequentFlyerArrivals = parseArrivalTimes(ffArrivals);
				System.out.println("Frequent Flyer Arrivals \n" + ffArrivals);
				frequentFlyerQueue = new PassengerQueue("Frequent Flyer", frequentFlyerArrivals);
			}
			else
			{
				double frequentFlyerArrivalRate = Double.parseDouble(p
						.getProperty("frequentFlyerArrivalRate"));
				System.out.println("Expected number of frequent flyer arrivals per hour: "
						+ frequentFlyerArrivalRate);
				frequentFlyerQueue.setArrivalRate(frequentFlyerArrivalRate / 60);
			}

			String rpArrivals = p.getProperty("regularPassengerArrivals");

			if (rpArrivals != null)
			{
				Queue<int[]> regularPassengerArrivals = parseArrivalTimes(rpArrivals);
				System.out.println("Reqular Passenger Arrivals \n" + rpArrivals);
				regularPassengerQueue = new PassengerQueue("Regular Passengers",
						regularPassengerArrivals);
			}
			else
			{
				double regularPassengerArrivalRate = Double.parseDouble(p
						.getProperty("regularPassengerArrivalRate"));
				System.out.println("Expected number of regular passenger arrivals per hour: "
						+ regularPassengerArrivalRate);
				regularPassengerQueue.setArrivalRate(regularPassengerArrivalRate / 60);
			}

			if (ffArrivals == null && rpArrivals == null)
			{
				int maxProcessingTime = Integer.parseInt(p.getProperty("maxProcessingTime"));
				System.out.println("Maximum service time in minutes: " + maxProcessingTime);
				Passenger.setMaxProcessingTime(maxProcessingTime);
			}

			frequentFlyerMax = Integer.parseInt(p.getProperty("frequentFlyerMax"));

			System.out.println("The maximum number of frequent flyers"
					+ "\nserved between regualar passengers: " + frequentFlyerMax);

			totalTime = Integer.parseInt(p.getProperty("totalSimulationTime"));

			System.out.println("The total simulation time in minutes: " + totalTime);

			showAll = Boolean.parseBoolean(p.getProperty("showAll"));

			System.out.println("Display minute-by-minute trace of simulation (Y or N): " + showAll);

		} catch (Exception ex)
		{
			ex.printStackTrace();
			System.exit(1);
		}
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

	}

	/** Method to run the simulation */
	private void runSimulation()
	{
		for (clock = 0; clock < totalTime; clock++)
		{
			frequentFlyerQueue.checkNewArrival(clock, showAll);
			regularPassengerQueue.checkNewArrival(clock, showAll);

			if (clock >= timeDone)
			{
				startServe();
			}
		}
	}

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
	}
}
