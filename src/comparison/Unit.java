package comparison;

public enum Unit {
    INCH(1), FEET(12), CENTIMETER(0.3937);

    private double valueInInch;

    Unit(double valueInInch) {
        this.valueInInch = valueInInch;
    }

    public double asStandard(double value) {
        return value * valueInInch;
    }
}
