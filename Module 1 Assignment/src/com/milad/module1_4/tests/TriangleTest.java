import com.milad.module1_4.Colour;
import com.milad.module1_4.Triangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

class TriangleTest {

    @Test public void testAreaFromWidthAndHeight(){
        Triangle test1 = new Triangle(50, 50, Colour.BLUE);
        Assertions.assertEquals((double) (50 * 50) /2, test1.getArea());
    }
}