package com.milad.module1_4;

public abstract class TwoDShape {
    private double width;
    private double height;
    private Colour colour;


    public TwoDShape(){
        width = 0;
        height = 0;
        colour = Colour.NONE;
    }

    public TwoDShape(double width, double height, Colour colour){
        this.width = width;
        this.height = height;
        this.colour = colour;
    }

    public abstract double getArea();

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
