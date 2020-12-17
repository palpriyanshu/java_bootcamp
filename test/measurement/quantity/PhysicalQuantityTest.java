package measurement.quantity;

import measurement.exception.UnitCategoryMismatchException;
import measurement.units.LengthUnit;
import measurement.units.VolumeUnit;
import org.junit.Test;

import static org.junit.Assert.*;

public class PhysicalQuantityTest {

    @Test
    public void shouldConsiderTwoEqualLengthAsEquivalent() {
        PhysicalQuantity oneFeet = new PhysicalQuantity(1, LengthUnit.FEET);
        PhysicalQuantity twelveInch = new PhysicalQuantity(12, LengthUnit.INCH);

        assertTrue(oneFeet.isEquivalent(twelveInch));
    }

    @Test
    public void shouldConsiderTwoUnEqualLengthAsNotEquivalent() {
        PhysicalQuantity oneFeet = new PhysicalQuantity(1, LengthUnit.FEET);
        PhysicalQuantity elevenInch = new PhysicalQuantity(11, LengthUnit.INCH);

        assertFalse(oneFeet.isEquivalent(elevenInch));
    }

    @Test
    public void shouldConsiderTwoEqualVolumesAsEquivalent() {
        PhysicalQuantity hundredGallon = new PhysicalQuantity(100, VolumeUnit.GALLON);
        PhysicalQuantity threeHundredSeventyEightLiters = new PhysicalQuantity(378, VolumeUnit.LITER);

        assertTrue(hundredGallon.isEquivalent(threeHundredSeventyEightLiters));
    }

    @Test
    public void shouldAddTwoLengths() throws UnitCategoryMismatchException {
        PhysicalQuantity oneInch = new PhysicalQuantity(1, LengthUnit.INCH);
        PhysicalQuantity oneFeet = new PhysicalQuantity(1, LengthUnit.FEET);
        PhysicalQuantity thirteenInch = new PhysicalQuantity(13, LengthUnit.INCH);

        assertEquals(thirteenInch, oneInch.add(oneFeet, LengthUnit.INCH));
    }

    @Test
    public void shouldAddTwoVolumes() throws UnitCategoryMismatchException {
        PhysicalQuantity oneLiter = new PhysicalQuantity(1, VolumeUnit.LITER);
        PhysicalQuantity hundredGallon = new PhysicalQuantity(1, VolumeUnit.GALLON);
        PhysicalQuantity fourPointSevenEightLiters = new PhysicalQuantity(4.78, VolumeUnit.LITER);

        assertEquals(fourPointSevenEightLiters, oneLiter.add(hundredGallon, VolumeUnit.LITER));
    }

    @Test
    public void shouldThrowsUnitCategoryMismatchExceptionIfTwoDifferentUnitIsAdded(){
        PhysicalQuantity oneLiter = new PhysicalQuantity(1, VolumeUnit.LITER);
        PhysicalQuantity oneFeet = new PhysicalQuantity(1, LengthUnit.FEET);
        assertThrows(UnitCategoryMismatchException.class, ()-> oneFeet.add(oneLiter,VolumeUnit.LITER));
    }
}