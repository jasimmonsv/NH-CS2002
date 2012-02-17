package com.jasimmonsv.Simmons_HW3;
import java.util.ArrayList;


public class Polynomial {
	private ArrayList<Term> poly;
	
	public Polynomial(Term t){
		poly = new ArrayList<Term>();
		poly.add(t);
	}//end constructor
	
	public Polynomial(int coeff, int exp){
		poly = new ArrayList<Term>();
		poly.add(new Term(coeff,exp));
	}//end constructor
	
	public Polynomial multiply (Polynomial p){
		if (p.poly.size()>1){ //p has more then one term
			
		}//end if
		else{
			int x = p.poly.get(0).coefficient;
			int y = p.poly.get(0).exponent;
			for (int i = 0; i<poly.size(); i++){
				poly.get(i).coefficient = poly.get(i).coefficient*x;
				poly.get(i).exponent = poly.get(i).exponent+y;
			}//end for loop
		}//end else
		
				return this;
	}//end method multiply
	
	public Polynomial add (Polynomial p){
		//search for existing exp	
		for (int i=0;i < p.poly.size();i++){
			for (int j= 0;j < poly.size(); j++){
				if (p.poly.get(i).compareTo(poly.get(j))==0){ //if exponents equal each other
					poly.get(j).coefficient = poly.get(j).coefficient + p.poly.get(i).coefficient;
					p.poly.get(i).coefficient=0;
					p.poly.get(i).exponent=0;
				}//end equal to if
				else if (p.poly.get(i).compareTo(poly.get(j))==1){//if exponent of p.poly is greater then poly 
					poly.add(j, new Term(p.poly.get(i).coefficient,p.poly.get(i).exponent));
					p.poly.get(i).coefficient=0;
					p.poly.get(i).exponent=0;
				}//end greater then if
			}//end inner for loop
		}//end outer for loop
		return this;
	}//end method add
	
	public void print (){
		for(int i = 0;i<poly.size();i++){
			System.out.print(poly.get(i).print());
			if (i < poly.size()-1)System.out.print("+");
		}//end for loop
		System.out.print("\n");
	}//end method print
}
