package measurement;

public enum Unit {
    INCH(2.5),
    FEET(30),
    CENTIMETER(1),
    MILLIMETER(0.1);

    private final double valueInCentimeter;

    Unit(double valueInCentimeter) {
        this.valueInCentimeter = valueInCentimeter;
    }

    public double calculateStandardValue(double value) {
        return value * this.valueInCentimeter;
    }
}
