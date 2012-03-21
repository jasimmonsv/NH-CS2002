package com.jasimmonsv.Simmons_HW4;

public class Student {

	private String name;
	private int idNum;
	
	public Student(){
		name = "John Doe";
		idNum = 123456;
	}//end default construct
	
	public Student (String name1, int idNum2){
		name = name1;
		idNum = idNum2;
	}//end construct
	
	@Override
	public String toString(){
		return (name);
	}
	
}//end class Student
