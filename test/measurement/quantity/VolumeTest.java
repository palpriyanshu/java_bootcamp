package measurement.quantity;

import measurement.units.VolumeUnit;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class VolumeTest {
    @Test
    public void shouldConsiderTwoEqualVolumesAsEquivalent() {
        Volume hundredGallon = new Volume(100, VolumeUnit.GALLON);
        Volume threeHundredSeventyEightLiters = new Volume(378, VolumeUnit.LITER);

        assertTrue(hundredGallon.isEquivalent(threeHundredSeventyEightLiters));
    }

    @Test
    public void shouldAddTwoVolumesAndRepresentInStandardUnit()  {
        Volume oneLiter = new Volume(1, VolumeUnit.LITER);
        Volume hundredGallon = new Volume(1, VolumeUnit.GALLON);
        Volume fourPointSevenEightLiters = new Volume(4.78, VolumeUnit.LITER);

        assertEquals(fourPointSevenEightLiters, oneLiter.add(hundredGallon));
    }
}