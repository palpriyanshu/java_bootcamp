package measurement.quantity;

import measurement.units.TemperatureUnit;

public class Temperature extends Quantity<TemperatureUnit> {
    public Temperature(double magnitude, TemperatureUnit unit) {
        super(magnitude, unit);
    }
}
