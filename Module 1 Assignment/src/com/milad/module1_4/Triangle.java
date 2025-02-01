package com.milad.module1_4;

public class Triangle extends TwoDShape implements Rotate {
    // Fields
    private double side1;
    private double side2; // treated as base/width of the triangle
    private double side3;
    private double rotation;

    /**
     * Triangle constructor with width and height as the main params, as well as a colour
     * @param width positive non-zero double as the width of the triangle
     * @param height positive non-zero double as the height of the triangle
     * @param colour a colour from the enum Colour as the colour of the triangle
     */
    public Triangle(double width, double height, Colour colour){
        super(width, height, colour);
        side2 = width;
    }

    /**
     * Triangle constructor with sides as the main params, as well as a colour. We get height using herons formula and width from side 2.
     * The sum of two sides must be greater than the third side
     * @param side1 positive non-zero double as the side 1 of the triangle.
     * @param side2 positive non-zero double as the side 2 (base/width) of the triangle
     * @param side3 positive non-zero double as the side 3 of the triangle
     * @param colour a colour from the enum Colour as the colour of the triangle
     */
    public Triangle(double side1, double side2, double side3, Colour colour){
        super();

        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;

        setWidth(side2);
        setHeight(heronsHeight());
        setColour(colour);
    }

    /**
     * Gets area of triangle by either using the sides or height & width.
     * @return area of triangle
     */
    @Override
    public double getArea(){
        if (getHeight() == 0){ // If we are using getArea to set height, then we must get area using the three sides.
            double s = (side1 + side2 + side3)/2; // s = (a + b + c)/2
            return Math.sqrt((s * (s-side1)) * (s-side2) * (s-side3)); // area = sqrt(s * (s-a) * (s-b) * (s-c))
        }

        // Otherwise, we can use (height and width)/2 to get area
        return (getHeight() * getWidth())/2;
    }

    /**
     * Gets height of triangle using herons formula
     * @return height of triangle
     */
    private double heronsHeight(){
        double area = getArea();
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
                "Side 3 length: " + side3 + ". Rotation: " + rotation + ". Colour: " + getColour();
    }

    // My Rotate interface override methods
    @Override
    public void rotate90() {
        rotation += 90;
    }

    @Override
    public void rotate180() {
        rotation += 180;
    }

    @Override
    public void rotate(double degrees) {
        rotation += degrees;
    }

    // Getter for rotation so I can test it
    public double getRotation(){
        return rotation;
    }
}
