package measurement;

public enum LengthUnit{
    INCH(2.5),
    FEET(30),
    CENTIMETER(1),
    MILLIMETER(0.1);

    private final double valueInCentimeter;

    LengthUnit(double valueInCentimeter) {
        this.valueInCentimeter = valueInCentimeter;
    }

    public double calculateStandardValue(double value) {
        return value * this.valueInCentimeter;
    }
}
