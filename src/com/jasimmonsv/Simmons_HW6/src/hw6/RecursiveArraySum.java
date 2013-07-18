package hw6;

public class RecursiveArraySum
{
	private static int iter = -1;
	/**
	 * Starting code for HW 6.4
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		int[] data = {1,2,3,4,5,6,7,8,9,10,11};
		System.out.println("Sum of given array: "+sumArray(data));
	}

	public static int sumArray(int[] toSum)
	{
		iter++;
		while (iter<toSum.length-1) return toSum[iter]+sumArray(toSum);
		return toSum[iter];
	}

}
