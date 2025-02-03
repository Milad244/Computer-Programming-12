import com.milad.module1_4.Colour;
import com.milad.module1_4.Triangle;
import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleTest {

    /*
     * Partitioned the testing for Triangle as follows:
     * Testing heronsHeight used in side constructed triangle (as it is only used there)
     * Testing the area formula from width and height constructed triangle
     * Testing the area formula from sides constructed triangle
     * Testing the color
     * Testing the rotation
     */

    /**
     * <pre>
     * Testing heronsHeight used in side constructed triangle (as it is only used there):
     * - Positive sides
     * - Side1 of 1 with other whole number sides
     * - Side2 of decimal number and whole number sides
     * - All sides of decimal number
     * - All sides of less than 1 decimal number
     * - Got expected values using online calculator src: <a href="https://www.omnicalculator.com/math/triangle-height">src</a>
     * - Not testing boundary of 0 and negative numbers because not permitted as specified in constructor
     * - Also made sure to follow the sum rule specified in the constructor
     * </pre>
     */
    @Test public void testHeronsHeight(){
        // Positive sides
        assertEquals(6.799, new Triangle(10, 9, 7, Colour.NONE).getHeight(), 3);
        // Side1 of 1 with other whole number sides
        assertEquals(0.9682, new Triangle(1, 2, 2, Colour.NONE).getHeight(), 3);
        // Side2 of decimal number and whole number sides
        assertEquals(92.3, new Triangle(166, 99.5, 100, Colour.NONE).getHeight(), 3);
        // All sides of decimal number
        assertEquals(20.45, new Triangle(50.95, 31.141, 25.675, Colour.NONE).getHeight(), 3);
        // All sides of less than 1 decimal number
        assertEquals(0.07272, new Triangle(0.63, 0.21, 0.4221, Colour.NONE).getHeight(), 3);
    }

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
        assertEquals(131.45, new Triangle(29, 23, 12, Colour.NONE).getArea(), 3);
        // Side1 of 1 with other whole number sides
        assertEquals(1.479, new Triangle(1, 3, 3, Colour.NONE).getArea(), 3);
        // Side2 of decimal number and whole number sides
        assertEquals(4369, new Triangle(175, 102.5, 99, Colour.NONE).getArea(), 3);
        // All sides of decimal number
        assertEquals(60.55, new Triangle(10.9, 11.1111, 15.615, Colour.NONE).getArea(), 3);
        // All sides of less than 1 decimal number
        assertEquals(0.03977, new Triangle(0.313, 0.28, 0.499999, Colour.NONE).getArea(), 3);
    }

    /**
     * <pre>
     * Testing the colour:
     * - None
     * - Green
     * - Blue
     * - Red
     * </pre>
     */
    @Test public void testColour(){
        Triangle triangle = new Triangle(1, 1, Colour.NONE);

        // None
        assertEquals(Colour.NONE, triangle.getColour());
        // Green
        triangle.setColour(Colour.GREEN);
        assertEquals(Colour.GREEN, triangle.getColour());
        // Blue
        triangle.setColour(Colour.BLUE);
        assertEquals(Colour.BLUE, triangle.getColour());
        // Red
        triangle.setColour(Colour.Red);
        assertEquals(Colour.Red, triangle.getColour());
    }

    /**
     * <pre>
     * Testing the rotation:
     * - rotate 90
     * - rotate 180
     * - rotate double
     * - Boundaries:
     * - rotate 1
     * - rotate 0
     * - rotate -1
     * </pre>
     */
    @Test public void testRotation(){
        Triangle triangle = new Triangle(1, 1, Colour.NONE);

        // rotate 90 Total = 90
        triangle.rotate90();
        assertEquals(90, triangle.getRotation(), 0);
        // rotate 180 Total = 270
        triangle.rotate180();
        assertEquals(270, triangle.getRotation(), 0);
        // rotate 88.8 Total = 358.8
        triangle.rotate(88.8);
        assertEquals(358.8, triangle.getRotation(), 0);
        // rotate 1 Total = 359.8
        triangle.rotate(1);
        assertEquals(359.8, triangle.getRotation(), 0);
        // rotate 0 Total = 359.8
        triangle.rotate(0);
        assertEquals(359.8, triangle.getRotation(), 0);
        // rotate -1 Total = 358.8
        triangle.rotate(-1);
        assertEquals(358.8, triangle.getRotation(), 0);
    }
}