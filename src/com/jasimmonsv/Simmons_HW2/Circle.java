package com.jasimmonsv.Simmons_HW2;
/*<exercise chapter="1" section="8" type="programming" number="1">*/


import java.util.Scanner;

/**
 * Represents a circle.
 * Extends Shape.
 */
public class Circle extends Shape {
    // Data Fields

    /** The radius of the circle */
    private double radius = 0;

    // Constructors
    /** Constructs a default Circle */
    public Circle() {
        super("Circle");
    }

    /**
     * Constructs a circle of the specified size.
     * @param radius the radius
     * @param height the height
     */
    public Circle(double radius) {
        super("Circle");
        this.radius = radius;
    }

    // Methods
    /**
     * Get the radius.
     * @return The width
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Compute the area.
     * @return The area of the circle
     */
    @Override
    public double computeArea() {
        return Math.PI * radius * radius;
    }

    /**
     * Compute the perimeter.
     * @return The perimeter of the circle
     */
    @Override
    public double computePerimeter() {
        return 2 * Math.PI * radius;
    }

    /** Read the attributes of the circle. */
    @Override
    public void readShapeData() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the radius of the Circle");
        radius = in.nextDouble();
    }

    /**
     * Create a string representation of the circle.
     * @return A string representation of the circle
     */
    @Override
    public String toString() {
        return super.toString() + ": radius is " + radius;
    }
}
/*</exercise>*/
