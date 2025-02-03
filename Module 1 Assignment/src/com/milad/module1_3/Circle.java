package com.milad.module1_3;

public class Circle extends TwoDShape{
    public final double PI = Math.PI;
    private double radius;

    /**
     * Constructor for circle that gets width and height from the radius param
     * @param radius positive non-zero double as the radius of circle
     */
    public Circle(double radius){
        super(radius * 2, radius * 2); // Height and width of a circle is its diameter (radius * 2)
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
        return "2D Circle. Height: " + getHeight() + ". Width: " + getWidth() + ". Radius: " + radius;
    }
}
