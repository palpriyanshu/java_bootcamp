package measurement.units;

import org.junit.Test;

import static org.junit.Assert.*;

public class LengthUnitTest {
    @Test
    public void shouldConvertInchToStandardValue() {
        assertEquals(2, LengthUnit.INCH.convertTo(2, LengthUnit.INCH),0.0 );
    }

    @Test
    public void shouldConvertFeetToStandardValue() {
        assertEquals(12, LengthUnit.FEET.convertTo(1, LengthUnit.INCH),0.0 );
    }

    @Test
    public void shouldConvertCentimeterToStandardValue() {
        assertEquals(0.8, LengthUnit.CENTIMETER.convertTo(2, LengthUnit.INCH),0.0 );
    }

    @Test
    public void shouldConvertMillimeterToStandardValue() {
        assertEquals(0.04, LengthUnit.MILLIMETER.convertTo(1, LengthUnit.INCH),0.0 );
    }
}
