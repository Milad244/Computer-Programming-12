package com.milad.module1_4;

public class Circle extends TwoDShape{
    // Fields
    public final double PI = Math.PI;
    private double radius;

    /**
     * Constructor for circle that gets width and height from the radius param
     * @param radius radius of circle
     * @param colour colour of circle
     */
    public Circle(double radius, Colour colour){
        super(radius * 2, radius * 2, colour); // Height and width of a circle is its diameter (radius * 2)
        this.radius = radius;
    }

    /**
     * Gets area of circle using area of circle from radius formula
     * @return area of circle
     */
    @Override
    public double getArea() {
        return PI*(Math.pow(radius, 2)); //Area of circle = pi * r^2
    }

    // Getters and Setters for radius
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    // My toString override method
    @Override
    public String toString() {
        return "2D Circle. Radius: " + radius + ". Colour: " + getColour();
    }
}
