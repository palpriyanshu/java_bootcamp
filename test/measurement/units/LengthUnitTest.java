package measurement.units;

import org.junit.Test;

import static org.junit.Assert.*;

public class LengthUnitTest {
    @Test
    public void shouldConvertInchToStandardValue() {
        assertEquals(2, LengthUnit.INCH.convertToBase(2),0.0 );
    }

    @Test
    public void shouldConvertFeetToStandardValue() {
        assertEquals(12, LengthUnit.FEET.convertToBase(1),0.0 );
    }

    @Test
    public void shouldConvertCentimeterToStandardValue() {
        assertEquals(0.8, LengthUnit.CENTIMETER.convertToBase(2),0.0 );
    }

    @Test
    public void shouldConvertMillimeterToStandardValue() {
        assertEquals(0.04, LengthUnit.MILLIMETER.convertToBase(1),0.0 );
    }

    @Test
    public void shouldConvertFromBase() {
        assertEquals(1, LengthUnit.FEET.convertFromBase(12),0.0 );
    }

    @Test
    public void shouldConvertFromBaseForInches() {
        assertEquals(1, LengthUnit.INCH.convertFromBase(1),0.0 );
    }
}
