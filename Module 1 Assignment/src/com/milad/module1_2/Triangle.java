package com.milad.module1_2;

public class Triangle extends TwoDShape{
    private double side1;
    private double side2;
    private double side3;

    /**
     * Triangle constructor with width and height as the main params
     * @param width positive non-zero double as the width of the triangle
     * @param height positive non-zero double as the height of the triangle
     */
    public Triangle(double width, double height){
        super(width, height);
        side2 = width;
    }

    /**
     * Triangle constructor with sides as the main params. We get height using herons formula and width from side 2.
     * The sum of two sides must be greater than the third side
     * @param side1 positive non-zero double as the side 1 of the triangle.
     * @param side2 positive non-zero double as the side 2 (base/width) of the triangle
     * @param side3 positive non-zero double as the side 3 of the triangle
     */
    public Triangle(double side1, double side2, double side3){
        super();

        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;

        setWidth(side2);
        setHeight(heronsHeight());
    }

    /**
     * Gets area of triangle by using its height & width: (h*w)/2
     * @return area of triangle
     */
    @Override
    public double getArea(){
        return (getHeight() * getWidth())/2;
    }

    /**
     * Gets height of triangle using herons formula and gets area from the sides because we only call this when we do not know height
     * @return height of triangle
     */
    private double heronsHeight(){
        double s = (side1 + side2 + side3)/2; // s = (a + b + c)/2
        double area = Math.sqrt((s * (s-side1)) * (s-side2) * (s-side3)); // area = sqrt(s * (s-a) * (s-b) * (s-c))
        return (2 * area)/side2; // height = (2*area)/base
    }

    // Getters and setters for triangle sides
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

    // My toString override method
    @Override
    public String toString() {
        return "2D Triangle. Height: " + getHeight() + ". Width: " + getWidth() + ". Side 1 length: " + side1 + ". Side 2 length: " + side2 + ". " +
                "Side 3 length: " + side3;
    }
}
