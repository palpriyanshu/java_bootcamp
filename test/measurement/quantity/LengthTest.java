package measurement.quantity;

import measurement.units.LengthUnit;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class LengthTest {
    @Test
    public void shouldConsiderTwoEqualLengthAsEquivalent() {
        Length oneFeet = new Length(1, LengthUnit.FEET);
        Length twelveInch = new Length(12, LengthUnit.INCH);

        assertTrue(oneFeet.isEquivalent(twelveInch));
    }

    @Test
    public void shouldConsiderTwoUnEqualLengthAsNotEquivalent() {
        Length oneFeet = new Length(1, LengthUnit.FEET);
        Length elevenInch = new Length(11, LengthUnit.INCH);

        assertFalse(oneFeet.isEquivalent(elevenInch));
    }

    @Test
    public void shouldAddTwoLengthsAndRepresentInStandardUnit()  {
        Length oneInch = new Length(1, LengthUnit.INCH);
        Length oneFeet = new Length(1, LengthUnit.FEET);
        Length thirteenInch = new Length(13, LengthUnit.INCH);

        assertEquals(thirteenInch, oneInch.add(oneFeet));
    }
}