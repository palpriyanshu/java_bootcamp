package measurement;

import org.junit.Test;

import static org.junit.Assert.*;

public class LengthTest {
    @Test
    public void shouldNotEquateTwoUnequalLengthsOfSameUnit() {
        Length fiveFeet = new Length(5, LengthUnit.FEET);
        Length tenFeet = new Length(10, LengthUnit.FEET);
        assertFalse(fiveFeet.isEquivalent(tenFeet));
    }

    @Test
    public void shouldEquateTwoEqualLengthsOfSameUnit() {
        Length tenFeet = new Length(10, LengthUnit.FEET);
        assertTrue(tenFeet.isEquivalent(tenFeet));
    }

    @Test
    public void shouldEquateTwoEqualLengthsOfDifferentUnit() {
        Length oneFeet = new Length(1, LengthUnit.FEET);
        Length twelveInch = new Length(12, LengthUnit.INCH);
        assertTrue(oneFeet.isEquivalent(twelveInch));
    }

    @Test
    public void shouldNotEquateTwoUnequalLengthsOfUnitInchAndCentimeter() {
        Length fourInch = new Length(4, LengthUnit.INCH);
        Length fiveCentimeter = new Length(5, LengthUnit.CENTIMETER);
        assertFalse(fourInch.isEquivalent(fiveCentimeter));
    }

    @Test
    public void shouldEquateTwoUnequalLengthsOfUnitCentimeterAndMillimeter() {
        Length oneCentimeter = new Length(1, LengthUnit.CENTIMETER);
        Length tenMillimeter = new Length(10, LengthUnit.MILLIMETER);
        assertTrue(tenMillimeter.isEquivalent(oneCentimeter));
    }

    @Test
    public void shouldAddTwoLengthsOfSameUnits() throws DifferentUnitsException {
        Length twoInches = new Length(2, LengthUnit.INCH);
        Length threeInches = new Length(3, LengthUnit.INCH);
        Length fiveInches = new Length(5, LengthUnit.INCH);
        assertEquals(fiveInches, threeInches.add(twoInches));
    }

    @Test
    public void shouldThrowDifferentDimensionsExceptionWhileAddingTwoLengthsOfDifferentUnits() throws DifferentUnitsException {
        Length twoInches = new Length(2, LengthUnit.INCH);
        Length threeFeet = new Length(3, LengthUnit.FEET);
        assertThrows(DifferentUnitsException.class, () -> twoInches.add(threeFeet));
    }
}
