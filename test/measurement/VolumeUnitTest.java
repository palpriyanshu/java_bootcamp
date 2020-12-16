package measurement;

import org.junit.Test;

import static org.junit.Assert.*;

public class VolumeUnitTest {

    @Test
    public void shouldConvertToGivenUnit() {
        assertEquals(3.78, VolumeUnit.GALLON.convertTo(1, VolumeUnit.LITER),0.0);
    }

    @Test
    public void shouldConvertToSameUnit() {
        assertEquals(1, VolumeUnit.LITER.convertTo(1, VolumeUnit.LITER),0.0);
    }
}