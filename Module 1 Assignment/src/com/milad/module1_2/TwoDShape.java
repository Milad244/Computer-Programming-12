package com.milad.module1_2;

public abstract class TwoDShape {
    private double width;
    private double height;

    /**
     * Default constructor for 2D shape, giving the shape a width and height of 0
     */
    public TwoDShape(){
        width = 0;
        height = 0;
    }

    /**
     * Constructor for 2D shape with params to set its width, height
     * @param width positive non-zero double as the width of 2D shape
     * @param height positive non-zero double as the height of 2D shape
     */
    public TwoDShape(double width, double height){
        this.width = width;
        this.height = height;
    }

    // Abstract method (must be overridden in child classes)
    public abstract double getArea();

    // Getters and Setters for width and height
    public void setHeight(double height){
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public String toString() {
        return "2D Shape. Width: " + width + ". Height: " + height;
    }
}
