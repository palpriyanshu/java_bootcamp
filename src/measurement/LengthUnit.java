package measurement;

public enum LengthUnit{
    INCH(1),
    FEET(12),
    CENTIMETER(0.4),
    MILLIMETER(0.04);

    private final double valueInInches;

    LengthUnit(double valueInInches) {
        this.valueInInches = valueInInches;
    }

    public double calculateStandardValue(double value) {
        return value * this.valueInInches;
    }

    public static LengthUnit standardUnit() {
        return INCH;
    }
}
