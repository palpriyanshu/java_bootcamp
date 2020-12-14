package comparison;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LengthTest {
    @Test
    public void shouldCompareUnequalLengthOfSameUnit() {
        Length length1 = new Length(5,Unit.FEET);
        Length length2 = new Length(10,Unit.FEET);
        assertEquals(Comparison.LESSER, length1.compareWith(length2));
    }

    @Test
    public void shouldCompareTwoEqualLengthsOfDifferentUnit() {
        Length lengthInFt = new Length(1,Unit.FEET);
        Length lengthInInch = new Length(12,Unit.INCH);
        assertEquals(Comparison.EQUAL, lengthInFt.compareWith(lengthInInch));
    }

    @Test
    public void shouldCompareUnequalLengthOfDifferentUnit() {
        Length lengthInFt = new Length(1,Unit.FEET);
        Length lengthInInch = new Length(11,Unit.INCH);
        assertEquals(Comparison.GREATER, lengthInFt.compareWith(lengthInInch));
    }

    @Test
    public void shouldCompareLengthInFeetAndLengthInInch() {
        Length length1 = new Length(2,Unit.FEET);
        Length length2 = new Length(6,Unit.INCH);
        assertEquals(Comparison.GREATER, length1.compareWith(length2));
    }

    @Test
    public void shouldCompareLengthInCentimeterAndLengthInInch() {
        Length length1 = new Length(2,Unit.INCH);
        Length length2 = new Length(6,Unit.CENTIMETER);
        assertEquals(Comparison.LESSER, length1.compareWith(length2));
    }
}
