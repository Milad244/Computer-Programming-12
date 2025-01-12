package com.milad.module1_1;

public class Triangle extends TwoDShape{
    private double side1;
    private double side2;
    private double side3;

    public Triangle(double width, double height){
        super(width, height);
        side1 = 0;
        side2 = 0;
        side3 = 0;
    }

    public Triangle(double side1, double side2, double side3){
        super();

        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;

        setHeight(heronsHeight());
    }

    @Override
    public double getArea(){
        // If statement to give area when only width and height are defined but sides are default
        if (side1 == 0 && side2 == 0 && side3 == 0){
            return (getHeight() * getWidth())/2;
        }

        double s = (side1 + side2 + side3)/2; // s = (a + b + c)/2
        return Math.sqrt((s * (s-side1)) * (s-side2) * (s-side3)); // area = sqrt(s * (s-a) * (s-b) * (s-c))
    }

    private double heronsHeight(){
        double area = getArea();
        return (2 * area)/side1; // height = (2*area)/base
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    @Override
    public String toString() {
        return "2D Triangle. Side 1 length: " + side1 + "; Side 2 length: " + side2 + "; Side 3 length: " + side3;
    }
}
