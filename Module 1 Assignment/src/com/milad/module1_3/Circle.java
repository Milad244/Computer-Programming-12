package com.milad.module1_3;

public class Circle extends TwoDShape{

    public final double PI = Math.PI;
    private double radius;

    public Circle(double radius){

        super(radius * 2, radius * 2); // Height and width of a circle is its diamater (radius * 2)
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return PI*(Math.pow(radius, 2)); //Area of circle = pi * r^2
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "2D Circle. Radius: " + radius;
    }
}
