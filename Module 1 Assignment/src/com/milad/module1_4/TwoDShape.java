package com.milad.module1_4;

public abstract class TwoDShape {
    private double width;
    private double height;
    private Colour colour;

    /**
     * Default constructor for 2D shape, giving the shape a width and height of 0, and no colour
     */
    public TwoDShape(){
        width = 0;
        height = 0;
        colour = Colour.NONE;
    }

    /**
     * Constructor for 2D shape with params to set its width, height, as well as a colour
     * @param width positive non-zero double as the width of 2D shape
     * @param height positive non-zero double as the height of 2D shape
     * @param colour a colour from the enum Colour as the colour of 2D shape
     */
    public TwoDShape(double width, double height, Colour colour){
        this.width = width;
        this.height = height;
        this.colour = colour;
    }

    // Abstract method (must be overridden in child classes)
    public abstract double getArea();

    // Getters and Setters for width, height, and colour
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

    public Colour getColour() {
        return colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "2D Shape. Width: " + width + ". Height: " + height + ". Colour: " + colour;
    }
}
