package com.jasimmonsv.Simmons_HW3;
import java.util.Date;

public class TestAssignmentList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Begin Test");
		Date assgnDate = new Date();
		Date dueDate = new Date();
		AssignmentList curList = new AssignmentList();
		// ************Populate Array List*********************************
		System.out.print("Add Assignments: ");
		assgnDate = new Date(2012-1900, 3, 15);
		dueDate= new Date(2012-1900, 3, 20);
		curList.add(new Assignment("HW 3", assgnDate, dueDate));
		System.out.print(".");
		assgnDate = new Date(2012-1900, 2, 7);
		dueDate = new Date(2012-1900, 2, 14);
		curList.add(new Assignment("HW 2", assgnDate, dueDate));
		System.out.print(".");
		assgnDate= new Date(2012-1900, 1, 5);
		dueDate= new Date(2012-1900, 1, 10);
		curList.add(new Assignment("HW 1", assgnDate, dueDate));
		System.out.print(".");
		assgnDate= new Date(2012-1900, 5, 5);
		dueDate= new Date(2012-1900, 5, 10);
		curList.add(new Assignment("HW 5", assgnDate, dueDate));
		System.out.print(".");
		assgnDate= new Date(2012-1900, 4, 5);
		dueDate= new Date(2012-1900, 4, 10);
		curList.add(new Assignment("HW 3", assgnDate, dueDate));
		System.out.print(". DONE!\n");
		// **********************Run Tests****************************
		Assignment earliestDue = curList.get(curList.earliestDue());
		System.out.println("Print by order assigned...");
		curList.print();
		System.out.println("Print by order assigned DONE!");
		System.out.println("Earliest Due Test...");
		System.out.println(earliestDue.print());
		System.out.println("Earliest Due Test DONE!");
		System.out.print("Remove Assignments: ");
		for (int i = curList.size()-1;i >= 0;i--)
			{curList.remove(i);System.out.print(".");}
		System.out.print(" DONE!\n");
		System.out.println("End Test");
	}// end main method

}// end Project 1 class
