package measurement.units;

import org.junit.Test;

import static org.junit.Assert.*;

public class TemperatureUnitTest {
    @Test
    public void shouldConvertCelsiusToBase() {
        assertEquals(1, TemperatureUnit.CELSIUS.convertToBase(1),0);
    }

    @Test
    public void shouldConvertFahrenheitToBase() {
        assertEquals(100, TemperatureUnit.FAHRENHEIT.convertToBase(212),0);
    }

    @Test
    public void shouldConvertCelsiusFromBase() {
        assertEquals(1, TemperatureUnit.CELSIUS.convertFromBase(1),0);
    }

    @Test
    public void shouldConvertFahrenheitFromBase() {
        assertEquals(212, TemperatureUnit.FAHRENHEIT.convertFromBase(100),0);
    }
}