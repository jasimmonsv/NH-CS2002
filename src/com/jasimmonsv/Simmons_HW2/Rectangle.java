package com.jasimmonsv.Simmons_HW2;
/*<listing chapter="1" number="7">*/
/**
 * Listing 1.7
 * @author Koffman and Wolfgang
 */


import java.util.Scanner;

/**
 * Represents a rectangle.
 * Extends Shape.
 */
public class Rectangle extends Shape {
    // Data Fields

    /** The width of the rectangle. */
    private double width = 0;
    /** The height of the rectangle. */
    private double height = 0;

    // Constructors
    /** Constructs a default Rectangle */
    public Rectangle() {
        super("Rectangle");
    }

    /**
     * Constructs a rectangle of the specified size.
     * @param width the width
     * @param height the height
     */
    public Rectangle(double width, double height) {
        super("Rectangle");
        this.width = width;
        this.height = height;
    }

    // Methods
    /**
     * Get the width.
     * @return The width
     */
    public double getWidth() {
        return width;
    }

    /**
     * Get the height.
     * @return The height
     */
    public double getHeight() {
        return height;
    }

    /**
     * Compute the area.
     * @return The area of the rectangle
     */
    @Override
    public double computeArea() {
        return height * width;
    }

    /**
     * Compute the perimeter.
     * @return The perimeter of the rectangle
     */
    @Override
    public double computePerimeter() {
        return 2 * (height + width);
    }

    /** 
     * Read the attributes of the rectangle.
     */
    @Override
    public void readShapeData() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the width of the Rectangle");
        width = in.nextDouble();
        System.out.println("Enter the height of the Rectangle");
        height = in.nextDouble();
    }

    /**
     * Create a string representation of the rectangle.
     * @return A string representation of the rectangle
     */
    @Override
    public String toString() {
        return super.toString() + ": width is " + width
                + ", height is " + height;
    }
}
/*</listing>*/
