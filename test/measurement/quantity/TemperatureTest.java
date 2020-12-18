package measurement.quantity;

import measurement.units.TemperatureUnit;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TemperatureTest {


    @Test
    public void shouldConsiderTwoEqualTemperatureAsEquivalent() {
        Temperature hundredCelsius = new Temperature(100, TemperatureUnit.CELSIUS);
        Temperature twoHundredTwelveFahrenheit = new Temperature(212, TemperatureUnit.FAHRENHEIT);

        assertTrue(hundredCelsius.isEquivalent(twoHundredTwelveFahrenheit));
    }

    @Test
    public void shouldConsiderTwoUnequalTemperatureAsNotEquivalent() {
        Temperature hundredCelsius = new Temperature(100, TemperatureUnit.CELSIUS);
        Temperature twoHundredFahrenheit = new Temperature(200, TemperatureUnit.FAHRENHEIT);

        assertFalse(hundredCelsius.isEquivalent(twoHundredFahrenheit));
    }
}