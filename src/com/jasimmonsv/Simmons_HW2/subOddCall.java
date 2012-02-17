package com.jasimmonsv.Simmons_HW2;

public class subOddCall extends OddCall{
	public String returnString;
	
	//Constructors
	public subOddCall() {
		returnString = this.classCall();
	}

	public String innerCall(){
		String innerString = "This is from the child subOddCall class";
		return innerString;
	}//end innerCall

}//end subOddCall class
