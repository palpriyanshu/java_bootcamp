package measurement;

import org.junit.Test;

import static org.junit.Assert.*;

public class LengthUnitTest {
    @Test
    public void shouldConvertInchToStandardValue() {
        assertEquals(2, LengthUnit.INCH.calculateStandardValue(2),0.0 );
    }

    @Test
    public void shouldConvertFeetToStandardValue() {
        assertEquals(12, LengthUnit.FEET.calculateStandardValue(1),0.0 );
    }

    @Test
    public void shouldConvertCentimeterToStandardValue() {
        assertEquals(0.8, LengthUnit.CENTIMETER.calculateStandardValue(2),0.0 );
    }

    @Test
    public void shouldConvertMillimeterToStandardValue() {
        assertEquals(0.04, LengthUnit.MILLIMETER.calculateStandardValue(1),0.0 );
    }
}
