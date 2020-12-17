package measurement.units;

public enum VolumeUnit implements Unit {
    LITER(1), GALLON(3.78);

    private final double conversionFactor;

    VolumeUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    private double convertToBaseValue(double value) {
        return value * this.conversionFactor;
    }

    @Override
    public double convertToBase(double value) {
        return value * this.conversionFactor;
    }

    @Override
    public double convertFromBase(double baseValue) {
        return baseValue / this.conversionFactor;
    }
}
