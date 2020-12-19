package measurement.units;

public enum TemperatureUnit implements Unit{
    CELSIUS(0,1),

    FAHRENHEIT(-32, 5.0/9.0);

    private final int constant;
    private final double slope;

    TemperatureUnit(int constant, double slope) {
        this.constant = constant;
        this.slope = slope;
    }

    @Override
    public double convertToBase(double value) {
        return (value + this.constant) * this.slope;

    }

    @Override
    public double convertFromBase(double baseValue) {
        return (baseValue / this.slope) - this.constant;
    }
}
