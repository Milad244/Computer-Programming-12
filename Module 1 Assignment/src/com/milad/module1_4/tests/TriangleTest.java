import com.milad.module1_4.Colour;
import com.milad.module1_4.Triangle;
import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleTest {

    /*
     * Partitioned the testing for Triangle as follows:
     * Testing the area formula from width and height constructed triangle.
     * Testing the area formula from sides constructed triangle.
     * Testing all the setters and getters including, height, width, colour, rotation, side1, side2, side3
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
     * Positive width and height
     * Decimal width and height
     * Decimal width and less than 1 decimal height
     */
    @Test public void testAreaFromSides(){

    }




}