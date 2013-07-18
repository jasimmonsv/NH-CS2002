package p5;

public class Problem5
{

	/**
	 * Starting code for Problem 5 of Take-Home Exam 2.
	 * 
	 * Complete the method boolean isHeapArray(int[] arr),
	 *   as described in the Exam handout.
	 *   
	 * Also complete Problem5.main(..) which demonstrates
	 *   your implementation of this method.
	 *   
	 */
	public static void main(String[] args)
	{
		int[] correct = {-1,0,1,43,3,3,2,65,58,40,42,4};
		int [] incorrect = {-1,0,1,43,3,3,2,15,58,40,42,4};
		
		System.out.println("Correct Array: (true) =>"+isHeapArray(correct));
		System.out.println("Incorrect Array: (false) =>"+isHeapArray(incorrect));
	
	}//end method main
	
	public static boolean isHeapArray(int[] array)
	{
		for (int i = 0;i<array.length;i++){
			if (array[0]>array[i])return false;
			if (array.length-1 >= (2*i)+1){	
				if(array[i]>array[(2*i)+1])return false;
				if(array.length-1 >= ((2*i)+2)){
					if(array[i]>array[(2*i)+2])return false;
				}//end if
			}//end if	
		}//end for
		return true; // complete this
	}//end method isHeapArray

}
