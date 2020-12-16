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
        PhysicalQuantity<LengthUnit> oneFeet = new PhysicalQuantity<>(1,LengthUnit.FEET);
        PhysicalQuantity<LengthUnit> oneInch = new PhysicalQuantity<>(1,LengthUnit.INCH);
        PhysicalQuantity<LengthUnit> twoInch = new PhysicalQuantity<>(2,LengthUnit.INCH);
    }
}