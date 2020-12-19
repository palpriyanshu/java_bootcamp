package measurement.units;

import org.junit.Test;

import static org.junit.Assert.*;

public class VolumeUnitTest {

    @Test
    public void shouldConvertToGivenUnit() {
        assertEquals(3.78, VolumeUnit.GALLON.convertToBase(1),0.0);
    }

    @Test
    public void shouldConvertToSameUnit() {
        assertEquals(1, VolumeUnit.LITER.convertToBase(1),0.0);
    }

    @Test
    public void shouldConvertToGallonFromBaseUnit() {
        assertEquals(1, VolumeUnit.GALLON.convertFromBase(3.78),0.0);
    }

    @Test
    public void shouldConvertToLiterFromBaseUnit() {
        assertEquals(1, VolumeUnit.LITER.convertFromBase(1),0.0);
    }
}