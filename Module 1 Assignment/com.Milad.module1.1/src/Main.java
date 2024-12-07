
public class Main {
    public static void main(String[] args) {
        /* Questions Here:
        How much commenting do I need? Please be specific.
        What side is the width of the triangle?
        What side is the base of the triangle?
        Cannot call heronsHeight() before super. If I made getArea and heronsHeight take params I could solve this
        but since you specified it to not take params am I missing another way of doing this?
        What should be my default fields for my TwoDShape() constructor and Triangle(double width, double height) constructor
        */

        TwoDShape shape = new TwoDShape(10, 5);
        System.out.println(shape.getArea());
        System.out.println(shape);

        TwoDShape shape2 = new Triangle(50, 50, 50);
        System.out.println(shape2);
    }
}