import com.milad.module1_4.Colour;
import com.milad.module1_4.Triangle;
import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleTest {

    /**
     * Partitioned the testing for Triangle as follows:
     * Testing the area formula from width and height constructed triangle.
     * Testing the area formula from sides constructed triangle.
     * 
     */


    /**
     * Positive width and height
     * Decimal width and height
     * less than 1 decimal width and decimal height
     */
    @Test public void testAreaFromWidthAndHeight(){
        Triangle testTriangleWH = new Triangle(50, 75, Colour.NONE);
        assertEquals((double) (50 * 75) /2, testTriangleWH.getArea(), 0);

        testTriangleWH.setHeight(65.9);
        testTriangleWH.setWidth(33.9);
        assertEquals((33.9 * 65.9) /2, testTriangleWH.getArea(), 0);

        testTriangleWH.setWidth(0.98);
        assertEquals((0.98 * 65.9) /2, testTriangleWH.getArea(), 0);
    }

    /**
     * Positive width and height
     * Decimal width and height
     * Decimal width and less than 1 decimal height
     */
    @Test public void testAreaFromSides(){
        Triangle testTriangleSides = new Triangle(30, 55, 12, Colour.NONE);
        //assertEquals(?, testTriangleSides.getArea(), 0);
    }




}