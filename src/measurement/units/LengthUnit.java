package measurement.units;

public enum LengthUnit implements Unit {
    INCH(1),
    FEET(12),
    CENTIMETER(0.4),
    MILLIMETER(0.04);

    private final double conversionFactor;

    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
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
