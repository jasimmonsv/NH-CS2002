package com.jasimmonsv.Simmons_HW2;
import java.util.Scanner;


public class Square extends Shape {

	//The side of the square
	private double side = 0;
	
	//Default Constructor
	public Square (){
	super("Square");
	}
	
	/**
     * Constructs a rectangle of the specified size.
     * @param width the width
     * @param height the height
     */
    public Square(double side) {
        super("Square");
        this.side = side;
    }

	@Override
	public double computeArea() {
		return side * side;
		
	}

	@Override
	public double computePerimeter() {
		return side * 4;
		
	}

	@Override
	public void readShapeData() {
		Scanner in = new Scanner(System.in);
        System.out.println("Enter the side length of the Square");
        side = in.nextDouble();
        
		
	}
    
    
}
