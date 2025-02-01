import com.milad.module1_4.Colour;
import com.milad.module1_4.Triangle;
import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleTest {

    /*
     * Partitioned the testing for Triangle as follows:
     * Testing the area formula from width and height constructed triangle.
     * Testing the area formula from sides constructed triangle.
     * Testing all the getters including, height, width, colour, rotation, side1, side2, side3 with both constructors
     */

    /**
     * <pre>
     * Testing the area formula from width and height constructed triangle:
     * - Positive width and height
     * - Width of 1 and whole number height (includes vise verse)
     * - Width of decimal number and whole number height (includes vise verse)
     * - Width of less than 1 decimal number and whole number height (includes vise verse)
     * - Width and height of decimal number
     * - Width and height of less than 1 decimal number
     * - Not testing boundary of 0 and negative numbers because not permitted as specified in constructor
     * </pre>
     */
    @Test public void testAreaFromWidthAndHeight(){
        // Positive width and height
        assertEquals((double) (50 * 75) /2, new Triangle(50, 75, Colour.NONE).getArea(), 0);
        // Width of 1 and whole number height (includes vise verse)
        assertEquals((double) (22) /2, new Triangle(1, 22, Colour.NONE).getArea(), 0);
        assertEquals((double) (993) /2, new Triangle(993, 1, Colour.NONE).getArea(), 0);
        // Width of decimal number and whole number height (includes vise verse)
        assertEquals((82.35 * 100) /2, new Triangle(82.35, 100, Colour.NONE).getArea(), 0);
        assertEquals((642 * 2.62) /2, new Triangle(642, 2.62, Colour.NONE).getArea(), 0);
        // Width of less than 1 decimal number and whole number height (includes vise verse)
        assertEquals((0.123 * 6) /2, new Triangle(0.123, 6, Colour.NONE).getArea(), 0);
        assertEquals((46 * 0.2) /2, new Triangle(46, 0.2, Colour.NONE).getArea(), 0);
        // Width and height of decimal number
        assertEquals((6.99 * 200.333) /2, new Triangle(6.99, 200.333, Colour.NONE).getArea(), 0);
        // Width and height of less than 1 decimal number
        assertEquals((0.631 * 0.852) /2, new Triangle(0.631, 0.852, Colour.NONE).getArea(), 0);
    }

    /**
     * <pre>
     * Testing the area formula from side constructed triangle:
     * - Positive sides
     * - Side1 of 1 with other whole number sides
     * - Side2 of decimal number and whole number sides
     * - All sides of decimal number
     * - All sides of less than 1 decimal number
     * - Got expected values using online calculator src: <a href="https://www.omnicalculator.com/math/3-sides-triangle-area">src</a>
     * - Not testing boundary of 0 and negative numbers because not permitted as specified in constructor
     * - Also made sure to follow the sum rule specified in the constructor
     * </pre>
     */
    @Test public void testAreaFromSides(){
        // Positive sides
        assertEquals(131.45, new Triangle(29, 23, 12, Colour.NONE).getArea(), 1);
        // Side1 of 1 with other whole number sides
        assertEquals(1.479, new Triangle(1, 3, 3, Colour.NONE).getArea(), 1);
        // Side2 of decimal number and whole number sides
        assertEquals(4369, new Triangle(175, 102.5, 99, Colour.NONE).getArea(), 1);
        // All sides of decimal number
        assertEquals(60.55, new Triangle(10.9, 11.1111, 15.615, Colour.NONE).getArea(), 1);
        // All sides of less than 1 decimal number
        assertEquals(0.03977, new Triangle(0.313, 0.28, 0.499999, Colour.NONE).getArea(), 1);
    }

    /**
     * <pre>
     * Testing all the getters including, height, width, colour, rotation, side1, side2, side3 with both constructors:
     * - Width and height constructor
     * - Side constructor
     * </pre>
     */
    @Test public void testGetters(){
        // Width and height constructor
        Triangle widthAndHeightTriangle = new Triangle(50, 75, Colour.BLUE);
        widthAndHeightTriangle.rotate90();

        assertEquals(50, widthAndHeightTriangle.getWidth(), 0);
        assertEquals(75, widthAndHeightTriangle.getHeight(), 0);
        assertEquals(Colour.BLUE, widthAndHeightTriangle.getColour());
        assertEquals(90, widthAndHeightTriangle.getRotation(), 0);
        assertEquals(50, widthAndHeightTriangle.getSide2(), 0); // Can only test side 2 from width & height constructor

        // Side constructor
        Triangle sideTriangle = new Triangle(29, 23, 12, Colour.Red);
        sideTriangle.rotate180();

        assertEquals(23, sideTriangle.getWidth(), 0);
        assertEquals((2 * 131.45)/23, sideTriangle.getHeight(), 1);
        assertEquals(Colour.Red, sideTriangle.getColour());
        assertEquals(180, sideTriangle.getRotation(), 0);
        assertEquals(29, sideTriangle.getSide1(), 0);
        assertEquals(23, sideTriangle.getSide2(), 0);
        assertEquals(12, sideTriangle.getSide3(), 0);
    }


}