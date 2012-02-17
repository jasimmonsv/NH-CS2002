package com.jasimmonsv.Simmons_HW2;

public class ChangabilityExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Application Start");
		SomeClass test = new SomeClass();
		SomeClass test3 = new SomeClass();
		SomeClass test2 = new childSomeClass();
		SomeClass test4 = new childSomeClass();
		describe(test);
		describe(test2);
		describe(test3);
		describe(test4);
		
	}//end Main
	
	public static void describe (SomeClass arg) {
		arg.printDescription(); // prints description of arg state 
	}//end describe
}//end Class
