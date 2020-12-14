package shape;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RectangleTest {
    @Test
    public void shouldCalculateArea() {
        Rectangle rectangle = new Rectangle(2, 3);
        assertEquals(6,rectangle.calculateArea(),0.0);
    }

    @Test
    public void shouldCalculateAreaForRectangleOfFloatingPointLengthAndBreadth() {
        Rectangle rectangle = new Rectangle(2.3, 3.1);
        assertEquals(7.13,rectangle.calculateArea(),0.0);
    }

    @Test
    public void shouldCalculatePerimeter() {
        Rectangle rectangle = new Rectangle(2, 3);
        assertEquals(10,rectangle.calculatePerimeter(),0.0);
    }

    @Test
    public void shouldCalculatePerimeterForRectangleOfFloatingPointLengthAndBreadth() {
        Rectangle rectangle = new Rectangle(2.5, 3.5);
        assertEquals(12.0,rectangle.calculatePerimeter(),0.0);
    }


}
