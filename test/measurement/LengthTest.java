package measurement;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LengthTest {
    @Test
    public void shouldInvalidateTwoUnequalLengthsOfSameUnit() {
        Length fiveFeet = new Length(5, LengthUnit.FEET);
        Length tenFeet = new Length(10, LengthUnit.FEET);
        assertFalse(fiveFeet.isEquivalent(tenFeet));
    }

    @Test
    public void shouldValidateTwoEqualLengthsOfSameUnit() {
        Length tenFeet = new Length(10, LengthUnit.FEET);
        assertTrue(tenFeet.isEquivalent(tenFeet));
    }

    @Test
    public void shouldValidateTwoEqualLengthsOfDifferentUnit() {
        Length oneFeet = new Length(1, LengthUnit.FEET);
        Length twelveInch = new Length(12, LengthUnit.INCH);
        assertTrue(oneFeet.isEquivalent(twelveInch));
    }

    @Test
    public void shouldInvalidateTwoUnequalLengthsOfUnitInchAndCentimeter() {
        Length fourInch = new Length(4, LengthUnit.INCH);
        Length fiveCentimeter = new Length(5, LengthUnit.CENTIMETER);
        assertFalse(fourInch.isEquivalent(fiveCentimeter));
    }

    @Test
    public void shouldValidateTwoUnequalLengthsOfUnitCentimeterAndMillimeter() {
        Length oneCentimeter = new Length(1, LengthUnit.CENTIMETER);
        Length tenMillimeter = new Length(10, LengthUnit.MILLIMETER);
        assertTrue(tenMillimeter.isEquivalent(oneCentimeter));
    }
}
