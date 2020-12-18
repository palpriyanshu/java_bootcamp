package measurement.units;

public enum TemperatureUnit implements Unit{
    CELSIUS(0,1),

    FAHRENHEIT(-32, 5.0/9.0);

    private final int additionFactor;
    private final double multiplier;

    TemperatureUnit(int additionFactor, double multiplier) {
        this.additionFactor = additionFactor;
        this.multiplier = multiplier;
    }

    @Override
    public double convertToBase(double value) {
        return (value + this.additionFactor) * this.multiplier;

    }

    @Override
    public double convertFromBase(double baseValue) {
        return (baseValue / this.multiplier ) - this.additionFactor;
    }
}
