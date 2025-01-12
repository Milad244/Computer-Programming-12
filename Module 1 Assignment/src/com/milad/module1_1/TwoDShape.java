package com.milad.module1_1;

public class TwoDShape {
    private double width;
    private double height;

    public TwoDShape(){
        width = 0;
        height = 0;
    }

    public TwoDShape(double width, double height){
        this.width = width;
        this.height = height;
    }

    public double getArea(){
        return width * height; // Is not correct for every 2D object, meant to be overridden
    }

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
        return "2D Shape with a width of " + width + " and a height of " + height;
    }
}
