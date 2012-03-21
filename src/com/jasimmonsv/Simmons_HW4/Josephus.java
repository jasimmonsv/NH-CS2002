package com.jasimmonsv.Simmons_HW4;
import java.util.Iterator;


public class Josephus
{
	//Declarations
	private static int n;
	private static int m;
	
	public static void main(String[] args)
	{
		CircularList<String> list = new CircularList<String>();
		
		String[] people =  { "one", 
							 "two", 
							 "three",
							 "four",
							 "five",
							 "six",
							 "seven",
							 "eight",
							 "nine",
							 "ten",
							 "eleven",
							 "twelve",
							 "thirteen",
							 "fourteen",
							 "fifteen",
							 "sixteen",
							 "seventeen",
							 "eighteen",
							 "nineteen",
							 "twenty",
							 "twenty-one",
							 "twenty-two",
							 "twenty-three",
							 "twenty-four",
							 "twenty-five",
							 "twenty-six",
							 "twenty-seven",
							 "twenty-eight",
							 "twenty-nine",
							 "thirty",};
		//collect vars n & m
		TextIO.putln("Enter number in the party: ");
		n = TextIO.getInt();
		while (n < 0 || n > 30){ //catch errors
			TextIO.putln("Enter a number between 0 and 30: ");
			n = TextIO.getInt();
		}//end if
		TextIO.putln("Enter how many iterations in a round: ");
		m = TextIO.getInt();
		while (m<0){//catch errors
			TextIO.putln("Enter a number larger then 0: ");
			m = TextIO.getInt();
		}
		
		for (int i = 0; i < n; i++)
		{
			list.addBeforeCurrent(people[i]);
		}//end for loop
		
		TextIO.putln ("size is: " + list.size());
		
		/**for (int count=0; count < 20; count++, list.advanceCurrent())
		{
			String n = list.getCurrent();
			TextIO.putln (n);
		}//end for loop
		*/
		
		String winner = killingTime(list);
		
		
		TextIO.putln ("The last man standing is " + winner);
			
		
	}//end main

	private static String killingTime(CircularList<String> list){
		while (list.size() > 1){
			for (int i=0;i<m-1;i++){
				list.advanceCurrent();
			}//end for loop
			list.removeCurrent();
		}//end while
		return list.getCurrent(); //return the last element in the list
	}//end method killingTime
}//end class Josephus 
