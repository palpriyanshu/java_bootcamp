package measurement.units;

public enum LengthUnit implements Unit {
    INCH(1),
    FEET(12),
    CENTIMETER(0.4),
    MILLIMETER(0.04);

    private final double valueInInches;

    LengthUnit(double valueInInches) {
        this.valueInInches = valueInInches;
    }

    @Override
    public double convertToBaseValue(double value) {
        return value * this.valueInInches;
    }

    @Override
    public double convertTo(double value, Unit unit) {
        LengthUnit lengthUnit = (LengthUnit) unit;
        double baseMagnitude = this.convertToBaseValue(value);
        return baseMagnitude / lengthUnit.valueInInches;
    }

    public static LengthUnit standardUnit() {
        return INCH;
    }
}
