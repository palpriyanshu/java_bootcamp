package measurement.quantity;

import measurement.units.LengthUnit;
import measurement.units.VolumeUnit;
import org.junit.Test;

import static org.junit.Assert.*;

public class PhysicalQuantityTest {

    @Test
    public void shouldConsiderTwoEqualLengthAsEquivalent() {
        PhysicalQuantity<LengthUnit> oneFeet = new PhysicalQuantity<>(1,LengthUnit.FEET);
        PhysicalQuantity<LengthUnit> twelveInch = new PhysicalQuantity<>(12,LengthUnit.INCH);

        assertTrue(oneFeet.isEquivalent(twelveInch));
    }

    @Test
    public void shouldConsiderTwoUnEqualLengthAsNotEquivalent() {
        PhysicalQuantity<LengthUnit> oneFeet = new PhysicalQuantity<>(1,LengthUnit.FEET);
        PhysicalQuantity<LengthUnit> elevenInch = new PhysicalQuantity<>(11,LengthUnit.INCH);

        assertFalse(oneFeet.isEquivalent(elevenInch));
    }

    @Test
    public void shouldConsiderTwoEqualVolumesAsEquivalent() {
        PhysicalQuantity<VolumeUnit> hundredGallon = new PhysicalQuantity<>(100, VolumeUnit.GALLON);
        PhysicalQuantity<VolumeUnit> threeHundredSeventyEightLiters = new PhysicalQuantity<>(378,VolumeUnit.LITER);

        assertTrue(hundredGallon.isEquivalent(threeHundredSeventyEightLiters));
    }

    @Test
    public void shouldAddTwoLengths() {
        PhysicalQuantity<LengthUnit> oneInch = new PhysicalQuantity<>(1,LengthUnit.INCH);
        PhysicalQuantity<LengthUnit> oneFeet = new PhysicalQuantity<>(1,LengthUnit.FEET);
        PhysicalQuantity<LengthUnit> thirteenInch = new PhysicalQuantity<>(13,LengthUnit.INCH);

        assertEquals(thirteenInch, oneInch.add(oneFeet, LengthUnit.INCH));
    }

    @Test
    public void shouldAddTwoVolumes() {
        PhysicalQuantity<VolumeUnit> oneLiter = new PhysicalQuantity<>(1,VolumeUnit.LITER);
        PhysicalQuantity<VolumeUnit> hundredGallon = new PhysicalQuantity<>(1, VolumeUnit.GALLON);
        PhysicalQuantity<VolumeUnit> fourPointSevenEightLiters = new PhysicalQuantity<>(4.78,VolumeUnit.LITER);

        assertEquals(fourPointSevenEightLiters, oneLiter.add(hundredGallon, VolumeUnit.LITER));
    }
}