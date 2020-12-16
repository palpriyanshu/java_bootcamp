package measurement;

import org.junit.Test;

import static org.junit.Assert.*;

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

    @Test
    public void shouldAddTwoVolumesOfSameUnits() {
        Volume oneLiter = new Volume(1, VolumeUnit.LITER);
        Volume twoLiter = new Volume(2, VolumeUnit.LITER);
        assertEquals(twoLiter, oneLiter.add(oneLiter));
    }

    @Test
    public void shouldAddTwoVolumesOfUnitGallonsAndLiters() {
        Volume oneGallon = new Volume(1, VolumeUnit.GALLON);
        Volume oneLiter = new Volume(1, VolumeUnit.LITER);
        Volume fourPointSevenEightLiters = new Volume(4.78, VolumeUnit.LITER);
        assertEquals(fourPointSevenEightLiters, oneGallon.add(oneLiter));
    }
}