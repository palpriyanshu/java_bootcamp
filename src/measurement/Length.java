package measurement;

public class Length {

    private final double value;
    private final LengthUnit unit;

    public Length(double value, LengthUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    private double asStandardValue() {
        return this.unit.calculateStandardValue(this.value);
    }

    public boolean isEquivalent(Length length) {
        double thisAsStandard = this.asStandardValue();
        double otherAsStandard = length.asStandardValue();

        return thisAsStandard == otherAsStandard;
    }
}
