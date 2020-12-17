package measurement.quantity;

import measurement.units.LengthUnit;
import measurement.units.VolumeUnit;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuantityTest {

    @Test
    public void shouldConsiderTwoEqualLengthAsEquivalent() {
        Quantity<LengthUnit> oneFeet = new Quantity<>(1, LengthUnit.FEET);
        Quantity<LengthUnit> twelveInch = new Quantity<>(12, LengthUnit.INCH);

        assertTrue(oneFeet.isEquivalent(twelveInch));
    }

    @Test
    public void shouldConsiderTwoUnEqualLengthAsNotEquivalent() {
        Quantity<LengthUnit> oneFeet = new Quantity<>(1, LengthUnit.FEET);
        Quantity<LengthUnit> elevenInch = new Quantity<>(11, LengthUnit.INCH);

        assertFalse(oneFeet.isEquivalent(elevenInch));
    }

    @Test
    public void shouldConsiderTwoEqualVolumesAsEquivalent() {
        Quantity<VolumeUnit> hundredGallon = new Quantity<>(100, VolumeUnit.GALLON);
        Quantity<VolumeUnit> threeHundredSeventyEightLiters = new Quantity<>(378, VolumeUnit.LITER);

        assertTrue(hundredGallon.isEquivalent(threeHundredSeventyEightLiters));
    }

    @Test
    public void shouldAddTwoLengthsAndRepresentInUnitOfFirstQuantityIfStandardUnitIsNotSpecified()  {
        Quantity<LengthUnit> oneCentimeter = new Quantity<>(1, LengthUnit.CENTIMETER);
        Quantity<LengthUnit> twentyMillimeter = new Quantity<>(20, LengthUnit.MILLIMETER);
        Quantity<LengthUnit> threeCentimeter = new Quantity<>(3, LengthUnit.CENTIMETER);

        assertEquals(threeCentimeter, oneCentimeter.add(twentyMillimeter));
    }

    @Test
    public void shouldAddTwoLengthsAndRepresentInStandardUnit()  {
        Quantity<LengthUnit> oneInch = new Quantity<>(1, LengthUnit.INCH);
        Quantity<LengthUnit> oneFeet = new Quantity<>(1, LengthUnit.FEET);
        Quantity<LengthUnit> thirteenInch = new Quantity<>(13, LengthUnit.INCH);

        oneInch.setStandardUnit(LengthUnit.INCH);
        assertEquals(thirteenInch, oneInch.add(oneFeet));
    }

    @Test
    public void shouldAddTwoVolumesAndRepresentInStandardUnit()  {
        Quantity<VolumeUnit> oneLiter = new Quantity<>(1, VolumeUnit.LITER);
        Quantity<VolumeUnit> hundredGallon = new Quantity<>(1, VolumeUnit.GALLON);
        Quantity<VolumeUnit> fourPointSevenEightLiters = new Quantity<>(4.78, VolumeUnit.LITER);

        oneLiter.setStandardUnit(VolumeUnit.LITER);
        assertEquals(fourPointSevenEightLiters, oneLiter.add(hundredGallon));
    }
}