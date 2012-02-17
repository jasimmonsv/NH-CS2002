package com.jasimmonsv.Simmons_HW2;

public abstract class OddCall {
	public String returnString;
	
	public OddCall(){
		returnString = classCall();
	}
	public String classCall(){
		return this.innerCall();
	}
	
	public String innerCall(){
		return "This string if from the Parent OddCall Class";
	}
}
