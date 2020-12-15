package measurement;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class VolumeTest {
    @Test
    public void shouldEquateTwoEqualVolumesOfUnitGallonsAndLiters() {
        Volume hundredGallon = new Volume(100, VolumeUnit.GALLON);
        Volume threeHundredSeventyEightLiters = new Volume(378, VolumeUnit.LITER);
        assertTrue(hundredGallon.isEquivalent(threeHundredSeventyEightLiters));
    }

    @Test
    public void shouldNotEquateTwoEqualVolumesOfUnitGallonsAndLiters() {
        Volume oneGallon = new Volume(1, VolumeUnit.GALLON);
        Volume oneLiter = new Volume(1, VolumeUnit.LITER);
        assertFalse(oneGallon.isEquivalent(oneLiter));
    }
}