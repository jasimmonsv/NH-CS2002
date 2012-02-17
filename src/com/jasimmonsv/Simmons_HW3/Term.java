package com.jasimmonsv.Simmons_HW3;

public class Term implements Comparable {

	
	public int coefficient;
	public int exponent;
	
	public Term(){
		coefficient=0;
		exponent=0;
	}//end default constructor
	
	public Term(int coeff, int exp){
		coefficient = coeff;
		exponent = exp;
	}//end constructor
	
	public String print(){
		return (coefficient+"x^"+exponent);
	}//end method print
	
	@Override 
	public String toString(){
		return String.valueOf(exponent);
	}
	@Override
	public int compareTo(Object o) {
		if (this.exponent < Integer.valueOf(o.toString())){return -1;}
		else if (this.exponent == Integer.valueOf(o.toString())){return 0;}
		else if (this.exponent > Integer.valueOf(o.toString())){return 1;}
		else throw new ClassCastException();
	}

	
}
