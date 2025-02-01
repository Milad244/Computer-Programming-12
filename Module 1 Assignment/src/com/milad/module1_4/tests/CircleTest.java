import com.milad.module1_4.Colour;
import com.milad.module1_4.Circle;
import org.junit.Test;

import static org.junit.Assert.*;

public class CircleTest {

    /*
     * Partitioned the testing for Circle as follows:
     * Testing the area
     * Testing the height and width
     * Testing the colour
     */

    /**
     * <pre>
     * Testing the area:
     * - Positive whole number radius
     * - Radius of 1
     * - Radius of > 1 decimal number
     * - Radius of < than 1 decimal number
     * - Not testing boundary of 0 and negative numbers because not permitted as specified in constructor
     * </pre>
     */
    @Test public void testArea(){
        // Positive whole number radius
        assertEquals((Math.PI * 25), new Circle(5, Colour.GREEN).getArea(), 0);
        // Radius of 1
        assertEquals((Math.PI * 1), new Circle(1, Colour.GREEN).getArea(), 0);
        // Radius of > 1 decimal number
        assertEquals((Math.PI * Math.pow(202.531, 2)), new Circle(202.531, Colour.GREEN).getArea(), 0);
        // Radius of < than 1 decimal number
        assertEquals((Math.PI * Math.pow(0.9889, 2)), new Circle(0.9889, Colour.GREEN).getArea(), 0);
    }

    /**
     * <pre>
     * Testing the height and width:
     * - Positive whole number radius
     * - Radius of 1
     * - Radius of > 1 decimal number
     * - Radius of < than 1 decimal number
     * - Not testing boundary of 0 and negative numbers because not permitted as specified in constructor
     * </pre>
     */
    @Test public void testHeightAndWidth(){
        // Positive whole number radius
        assertEquals(98 * 2, new Circle(98, Colour.GREEN).getHeight(), 0);
        assertEquals(98 * 2, new Circle(98, Colour.GREEN).getWidth(), 0);
        // Radius of 1
        assertEquals(2, new Circle(1, Colour.GREEN).getHeight(), 0);
        assertEquals(2, new Circle(1, Colour.GREEN).getWidth(), 0);
        // Radius of > 1 decimal number
        assertEquals(47.09 * 2, new Circle(47.09, Colour.GREEN).getHeight(), 0);
        assertEquals(47.09 * 2, new Circle(47.09, Colour.GREEN).getWidth(), 0);
        // Radius of < than 1 decimal number
        assertEquals(0.15213 * 2, new Circle(0.15213, Colour.GREEN).getHeight(), 0);
        assertEquals(0.15213 * 2, new Circle(0.15213, Colour.GREEN).getWidth(), 0);
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
        Circle circle = new Circle(1, Colour.NONE);

        // None
        assertEquals(Colour.NONE, circle.getColour());
        // Green
        circle.setColour(Colour.GREEN);
        assertEquals(Colour.GREEN, circle.getColour());
        // Blue
        circle.setColour(Colour.BLUE);
        assertEquals(Colour.BLUE, circle.getColour());
        // Red
        circle.setColour(Colour.Red);
        assertEquals(Colour.Red, circle.getColour());
    }
}