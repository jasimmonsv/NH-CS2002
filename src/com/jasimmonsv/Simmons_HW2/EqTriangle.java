package com.jasimmonsv.Simmons_HW2;
import java.util.Scanner;


public class EqTriangle extends Shape {

	//The side of the square
		private double side = 0;
		
		//Default Constructor
		public EqTriangle (){
		super("EqTriangle");
		}//end default constructor
		
		/**
	     * Constructs a rectangle of the specified size.
	     * @param width the width
	     * @param height the height
	     */
	    public EqTriangle(double side) {
	        super("Equilateral Triangle");
	        this.side = side;
	    }//end constructor
	    
	@Override
	public double computeArea() {
		return 0.5 * side * side;
	}

	@Override
	public double computePerimeter() {
		return side * 3;
	}

	@Override
	public void readShapeData() {
		Scanner in = new Scanner(System.in);
        System.out.println("Enter the side length of the Equilateral Triangle");
        side = in.nextDouble();

	}

}
