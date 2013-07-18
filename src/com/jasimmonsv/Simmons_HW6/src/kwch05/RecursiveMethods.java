package kwch05;

/**
 * A class for recursive methods
 * 
 * @author Koffman and Wolfgang
 */
public class RecursiveMethods
{

	/* <example chapter="5" number="1"> */
	/**
	 * Recursive method length (in RecursiveMethods.java).
	 * 
	 * @param str
	 *            The string
	 * @return The length of the string
	 */
	public static int length(String str)
	{
		if (str == null || str.equals(""))
		{
			return 0;
		}
		else
		{
			return 1 + length(str.substring(1));
		}
	}

	/* </example> */

	/* <example chapter="5" number="2"> */
	/**
	 * Recursive method printChars (in RecursiveMethods.java).
	 * 
	 * @post The argument string is displayed one character per line.
	 * @param str
	 *            The string
	 */
	public static void printChars(String str)
	{
		if (str == null || str.equals(""))
		{
			return;
		}
		else
		{
			System.out.println(str.charAt(0));
			printChars(str.substring(1));
		}
	}

	/**
	 * Recursive method printCharsReverse (in RecursiveMethods.java).
	 * 
	 * @post The argument string is displayed in reverse, one character per
	 *       line.
	 * @param str
	 *            The string
	 */
	public static void printCharsReverse(String str)
	{
		if (str == null || str.equals(""))
		{
			return;
		}
		else
		{
			printCharsReverse(str.substring(1));
			System.out.println(str.charAt(0));
		}
	}

	/* </example> */

	/* <example chapter="5" number="4"> */
	/**
	 * Recursive factorial method (in RecursiveMethods.java).
	 * 
	 * @pre n >= 0
	 * @param n
	 *            The integer whose factorial is being computed
	 * @return n!
	 */
	public static int factorial(int n)
	{
		if (n == 0)
		{
			return 1;
		}
		else
		{
			return n * factorial(n - 1);
		}
	}

	/* </example> */

	/* <example chapter="5" number="5"> */
	/**
	 * Recursive power method (in RecursiveMethods.java).
	 * 
	 * @pre n >= 0
	 * @param x
	 *            The number being raised to a power
	 * @param n
	 *            The exponent
	 * @return x raised to the power n
	 */
	public static double power(double x, int n)
	{
		if (n == 0)
		{
			return 1;
		}
		else
		{
			return x * power(x, n - 1);
		}
	}

	/* </example> */

	/* <example chapter="5" number="6"> */
	/**
	 * Recursive gcd method (in RecursiveMethods.java).
	 * 
	 * @pre m > 0 and n > 0
	 * @param m
	 *            The larger number
	 * @param n
	 *            The smaller number
	 * @return Greatest common divisor of m and n
	 */
	public static double gcd(int m, int n)
	{
		if (m % n == 0)
		{
			return n;
		}
		else if (m < n)
		{
			return gcd(n, m); // Transpose arguments.
		}
		else
		{
			return gcd(n, m % n);
		}
	}

	/* </example> */

	/* <example chapter="5" number="7"> */
	/**
	 * Iterative factorial method.
	 * 
	 * @pre n >= 0
	 * @param n
	 *            The integer whose factorial is being computed
	 * @return n!
	 */
	public static int factorialIter(int n)
	{
		int result = 1;
		for (int k = 1; k <= n; k++)
		{
			result *= k;
		}
		return result;
	}

	/* </example> */

	/* <example chapter="5" number="8"> */
	/**
	 * Recursive method to calculate Fibonacci numbers (in
	 * RecursiveMethods.java).
	 * 
	 * @pre n >= 1
	 * @param n
	 *            The position of the Fibonacci number being calculated
	 * @return The Fibonacci number
	 */
	public static int fibonacci(int n)
	{
		if (n <= 2)
		{
			return 1;
		}
		else
		{
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}

	/**
	 * Recursive O(n) method to calculate Fibonacci numbers (in
	 * RecursiveMethods.java).
	 * 
	 * @pre n >= 1
	 * @param fibCurrent
	 *            The current Fibonacci number
	 * @param fibPrevious
	 *            The previous Fibonacci number
	 * @param n
	 *            The count of Fibonacci numbers left to calculate
	 * @return The value of the Fibonacci number calculated so far
	 */
	private static int fibo(int fibCurrent, int fibPrevious, int n)
	{
		if (n == 1)
		{
			return fibCurrent;
		}
		else
		{
			return fibo(fibCurrent + fibPrevious, fibCurrent, n - 1);
		}
	}

	/**
	 * Wrapper method for calculating Fibonacci numbers (in
	 * RecursiveMethods.java).
	 * 
	 * @pre n >= 1
	 * @param n
	 *            The position of the desired Fibonacci number
	 * @return The value of the nth Fibonacci number
	 */
	public static int fibonacciStart(int n)
	{
		return fibo(1, 0, n);
	}

	/* </example> */

	/* <listing chapter="5" section="3"> */
	/**
	 * Recursive linear search method (in RecursiveMethods.java).
	 * 
	 * @param items
	 *            The array being searched
	 * @param target
	 *            The item being searched for
	 * @param posFirst
	 *            The position of the current first element
	 * @return The subscript of target if found; otherwise -1
	 */
	private static int linearSearch(Object[] items, Object target, int posFirst)
	{
		if (posFirst == items.length)
		{
			return -1;
		}
		else if (target.equals(items[posFirst]))
		{
			return posFirst;
		}
		else
		{
			return linearSearch(items, target, posFirst + 1);
		}
	}

	/**
	 * Wrapper for recursive linear search method (in RecursiveMethods.java).
	 * 
	 * @param items
	 *            The array being searched
	 * @param target
	 *            The object being searched for
	 * @return The subscript of target if found; otherwise -1
	 */
	public static int linearSearch(Object[] items, Object target)
	{
		return linearSearch(items, target, 0);
	}

	/* </listing> */

	/* <listing chapter="5" number="1"> */
	/**
	 * Recursive binary search method (in RecursiveMethods.java).
	 * 
	 * @param items
	 *            The array being searched
	 * @param target
	 *            The object being searched for
	 * @param first
	 *            The subscript of the first element
	 * @param last
	 *            The subscript of the last element
	 * @return The subscript of target if found; otherwise -1.
	 */
	private static int binarySearch(Object[] items, Comparable<Object> target, int first, int last)
	{
		if (first > last)
		{
			return -1; // Base case for unsuccessful search.
		}
		else
		{
			int middle = (first + last) / 2; // Next probe index.
			int compResult = target.compareTo(items[middle]);
			if (compResult == 0)
			{
				return middle; // Base case for successful search.
			}
			else if (compResult < 0)
			{
				return binarySearch(items, target, first, middle - 1);
			}
			else
			{
				return binarySearch(items, target, middle + 1, last);
			}
		}
	}

	/**
	 * Wrapper for recursive binary search method (in RecursiveMethods.java).
	 * 
	 * @param items
	 *            The array being searched
	 * @param target
	 *            The object being searched for
	 * @return The subscript of target if found; otherwise -1.
	 */
	public static int binarySearch(Object[] items, Comparable<Object> target)
	{
		return binarySearch(items, target, 0, items.length - 1);
	}

	/* </listing> */

	/* <exercise chapter="5" section="1" type="programming" number="1"> */
	public static int toNumber(String s)
	{
		if (s == null || s.length() == 0)
		{
			return 0;
		}
		char next = s.charAt(0);
		if (Character.isDigit(next))
		{
			return Character.digit(next, 10) + toNumber(s.substring(1));
		}
		else
		{
			return toNumber(s.substring(1));
		}
	}

	/* </exercise> */

	/* <exercise chapter="5" section="1" type="programming" number="2"> */
	public static String stutter(String s)
	{
		if (s == null || s.length() == 0)
		{
			return "";
		}
		char next = s.charAt(0);
		return next + next + stutter(s.substring(1));
	}

	/* </exercise> */

	/* <exercise chapter="5" section="1" type="programming" number="3"> */
	public static boolean searchString(String str, char ch)
	{
		if (str == null || str.length() == 0)
		{
			return false;
		}
		if (str.charAt(0) == ch)
		{
			return true;
		}
		return searchString(str.substring(1), ch);
	}

	/* </exercise> */

	/* <exercise chapter="5" section="2" type="programming" number="1"> */
	/**
	 * Recursive power method (in RecursiveMethods.java).
	 * 
	 * @param x
	 *            The number being raised to a power
	 * @param n
	 *            The exponent
	 * @return x raised to the power n
	 */
	public static double power2(double x, int n)
	{
		if (n < 0)
		{
			return 1.0 / power2(x, -n);
		}
		if (n == 0)
		{
			return 1;
		}
		else
		{
			return x * power2(x, n - 1);
		}
	}

	/* </exercise> */

	/* <exercise chapter="5" section="2" type="programming" number="2"> */
	/**
	 * Recursive factorial method (in RecursiveMethods.java).
	 * 
	 * @pre n >= 0
	 * @param n
	 *            The integer whose factorial is being computed
	 * @return n!
	 * @throws IllegalArgumentException
	 *             if n < 0
	 */
	public static int factorial2(int n)
	{
		if (n < 0)
		{
			throw new IllegalArgumentException("Negative n: " + n);
		}
		if (n == 0)
		{
			return 1;
		}
		else
		{
			return n * factorial2(n - 1);
		}
	}

	/*
	 * </exercise>
	 * 
	 * /*<exercise chapter="5" section="2" type="programming" number="3">
	 */

	/**
	 * Recursive method to calculate Fibonacci numbers (in
	 * RecursiveMethods.java).
	 * 
	 * @pre n >= 1
	 * @param n
	 *            The position of the Fibonacci number being calculated
	 * @return The Fibonacci number
	 * @throws IllegalArgumentException
	 *             if n <= 0
	 */
	public static int fibonacci2(int n)
	{
		if (n <= 0)
		{
			throw new IllegalArgumentException("n <= 0: " + n);
		}
		if (n <= 2)
		{
			return 1;
		}
		else
		{
			return fibonacci2(n - 1) + fibonacci2(n - 2);
		}
	}

	/* </exercise> */

	/* <exercise chapter="5" section="3" type="programming" number="2"> */
	/**
	 * Recursive linear search method (in RecursiveMethods.java).
	 * 
	 * @param items
	 *            The array being searched
	 * @param target
	 *            The item being searched for
	 * @param posFirst
	 *            The position of the current first element
	 * @return The subscript of target if found; otherwise -1
	 */
	private static int linearSearchReverse(Object[] items, Object target, int posLast)
	{
		if (posLast == -1)
		{
			return -1;
		}
		else if (target.equals(items[posLast]))
		{
			return posLast;
		}
		else
		{
			return linearSearch(items, target, posLast - 1);
		}
	}

	/**
	 * Wrapper for recursive linear search method (in RecursiveMethods.java).
	 * 
	 * @param items
	 *            The array being searched
	 * @param target
	 *            The object being searched for
	 * @return The subscript of target if found; otherwise -1
	 */
	public static int linearSearchReverse(Object[] items, Object target)
	{
		return linearSearchReverse(items, target, items.length - 1);
	}

	/* </exercise> */

	/* <exercise chapter="5" section="3" type="programming" number="1"> */
	private static int sum(int[] array, int index)
	{
		if (index == array.length)
		{
			return 0;
		}
		else
		{
			return array[index] + sum(array, index + 1);
		}
	}

	public static int sum(int[] array)
	{
		return sum(array, 0);
	}

	/* </exercise> */

	/* <exercise chapter="5" section="3" type="programming" number="3"> */
	/**
	 * Method to return the maximum integer in an array
	 * 
	 * @param array
	 *            The array of integers to search
	 * @param index
	 *            The index of the current value to consider
	 * @return the maximum value in the array
	 */
	private static int max(int[] array, int index)
	{
		if (index == array.length - 1)
		{
			return array[index];
		}
		int maxRest = max(array, index + 1);
		if (array[index] > maxRest)
		{
			return array[index];
		}
		else
		{
			return maxRest;
		}
	}

	/** Wrapper for recursive max method */
	public static int max(int[] array)
	{
		return max(array, 0);
	}

	/* </exercise> */

	/* <exercise chapter="5" section="3" type="programming" number="4"> */
	/**
	 * Method to search a string for a target character
	 * 
	 * @param s
	 *            The string to search
	 * @param t
	 *            The target
	 * @param i
	 *            The current index
	 * @return The index of the target character or -1 if not present
	 */
	private static int search(String s, char t, int i)
	{
		if (i == s.length())
		{
			return -1;
		}
		if (t == s.charAt(i))
		{
			return i;
		}
		return search(s, t, i + 1);
	}

	public static int search(String s, char t)
	{
		return search(s, t, 0);
	}
	/* </exercise> */
}
