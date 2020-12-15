package measurement;

import org.junit.Test;

import static org.junit.Assert.*;

public class UnitTest {
    @Test
    public void shouldConvertInchToStandardValue() {
        assertEquals(5, Unit.INCH.calculateStandardValue(2),0.0 );
    }

    @Test
    public void shouldConvertFeetToStandardValue() {
        assertEquals(30, Unit.FEET.calculateStandardValue(1),0.0 );
    }

    @Test
    public void shouldConvertCentimeterToStandardValue() {
        assertEquals(2, Unit.CENTIMETER.calculateStandardValue(2),0.0 );
    }

    @Test
    public void shouldConvertMillimeterToStandardValue() {
        assertEquals(0.1, Unit.MILLIMETER.calculateStandardValue(1),0.0 );
    }
}
