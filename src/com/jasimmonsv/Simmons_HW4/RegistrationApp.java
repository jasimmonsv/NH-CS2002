package com.jasimmonsv.Simmons_HW4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RegistrationApp {

	//Declarations
	private static String inStr=" ";
	private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	private static StudentList regList = new StudentList();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while (!inStr.isEmpty()){
			printMenu();
			try {
				inStr = in.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}//end try
		
			if (inStr.equalsIgnoreCase("1")){addStudent();}//addStudent
			else if (inStr.equalsIgnoreCase("2")){addPrioStudent();}//add priorityStudent
			else if (inStr.equalsIgnoreCase("3")){removeStudent();}//Remove next Student
			else if (inStr.equalsIgnoreCase("4")){
				System.out.println("Enter in the Name of the student to remove:");
				String stuName="";
				try {
					stuName = in.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				removeStudent(stuName);
				}//Remove by studentName
			else if (inStr.equalsIgnoreCase("5")){printList();}//prints list of students
			else if (inStr.equalsIgnoreCase("x"))System.exit(0);
			else {
				throw new IllegalArgumentException("Selection not recognized.");
			}//end else
		}//end while
	}//end main method

	private static void printMenu(){
		System.out.println("\t 1 - Add student \n\t 2 - Add priority student \n\t 3 - Remove next student " +
				"\n\t 4 - Remove by student name \n\t 5 - Print Student List \n\t x - Exit");		
	}//end method printMenu
	
	/**
	 * Add a student to the list
	 */
	private static void addStudent(){
		String stuName="";
		int stuID = 0;
		System.out.println("Enter Name of student: ");
		try {
			stuName = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Enter student ID number: ");
		try {
			stuID = Integer.valueOf(in.readLine());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		regList.add(new Student(stuName, stuID));
		
	}//end method addStudent
	
	/**
	 * Add priority student to the front of the list
	 */
	private static void addPrioStudent(){
		String stuName="";
		int stuID = 0;
		System.out.println("Enter Name of student: ");
		try {
			stuName = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Enter student ID number: ");
		try {
			stuID = Integer.valueOf(in.readLine());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		regList.add(0, new Student(stuName, stuID));
		
	}//end method addPrioStudent
	
	/**
	 * Remove student by student name
	 * @param stuName name of student to remove
	 */
	private static void removeStudent(String stuName){
		System.out.print("Removing... ");
		regList.removeName(stuName);
		System.out.println("Done!");
	}//end method removeStudent
	
	private static void removeStudent(){
		System.out.println("Removing...");
		regList.removeBeg();
		System.out.println("Done!");
	}//end method removeStudent
	
	private static void printList(){
		regList.printList();
	}//end method printList
	
}//end class RegistrationApp 
