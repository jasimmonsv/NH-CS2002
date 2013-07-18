package kwch05;

/*<exercise chapter="5" section="2" type="programming" number="4">*/
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class for calculating Fibonacci numbers that uses an ArrayList to store each
 * number calculated. If a value has been previously calculated it is used.
 * Otherwise the iteration starts with the largest value available.
 */
public class Fibonacci
{

	private static List<Long> fibValues = new ArrayList<Long>();

	static
	{
		fibValues.add(0L);
		fibValues.add(1L);
		fibValues.add(1L);
	}

	/**
	 * Calculate the nth fibonacci number
	 * 
	 * @return The nth fibonacci number
	 * @throws IllegalArgumentException
	 *             if n <= 0
	 */
	public static long fib(int n)
	{
		if (n <= 0)
		{
			throw new IllegalArgumentException(n + " <= 0 for fibonacci");
		}
		if (n == 1)
		{
			return 1;
		}
		if (n <= fibValues.size() - 1)
		{
			return fibValues.get(n);
		}
		int i = fibValues.size();
		long fibim1 = fibValues.get(i - 1);
		long fibim2 = fibValues.get(i - 2);
		long fibi = 0;
		while (i <= n)
		{
			fibi = fibim1 + fibim2;
			fibValues.add(fibi);
			i++;
			fibim2 = fibim1;
			fibim1 = fibi;
		}
		return fibi;
	}

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter number > 0");
		while (in.hasNextInt())
		{
			int n = in.nextInt();
			System.out.println("Fib(" + n + ") is " + fib(n));
			System.out.println("Enter number > 0");
		}
	}
}

/* </exercise> */
