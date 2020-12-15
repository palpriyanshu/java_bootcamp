package measurement;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LengthTest {
    @Test
    public void shouldCompareUnequalLengthOfSameUnit() {
        Length fiveFeet = new Length(5,Unit.FEET);
        Length tenFeet = new Length(10,Unit.FEET);
        assertFalse( fiveFeet.equals(tenFeet));
    }

    @Test
    public void shouldCompareEqualLengthOfSameUnit() {
        Length tenFeet = new Length(10,Unit.FEET);
        assertTrue( tenFeet.equals(tenFeet));
    }

    @Test
    public void shouldCompareEqualLengthsOfDifferentUnit() {
        Length oneFeet = new Length(1,Unit.FEET);
        Length twelveInch = new Length(12,Unit.INCH);
        assertTrue( oneFeet.equals(twelveInch));
    }

    @Test
    public void shouldCompareUnequalLengthOfUnitInchAndCentimeter() {
        Length fourInch = new Length(4,Unit.INCH);
        Length fiveCentimeter = new Length(5,Unit.CENTIMETER);
        assertFalse(fourInch.equals(fiveCentimeter));
    }

    @Test
    public void shouldCompareUnequalLengthOfUnitCentimeterAndMillimeter() {
        Length oneCentimeter = new Length(1,Unit.CENTIMETER);
        Length tenMillimeter = new Length(10,Unit.MILLIMETER);
        assertTrue( tenMillimeter.equals(oneCentimeter));
    }
}
