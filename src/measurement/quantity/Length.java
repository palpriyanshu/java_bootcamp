package measurement.quantity;

import measurement.units.LengthUnit;

import java.util.Objects;

public class Length {

    private final double value;
    private final LengthUnit unit;

    public Length(double value, LengthUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    private double asStandardValue() {
        return this.unit.convertToBaseValue(this.value);
    }

    public boolean isEquivalent(Length length) {
        double thisAsStandard = this.asStandardValue();
        double otherAsStandard = length.asStandardValue();

        return thisAsStandard == otherAsStandard;
    }

    public Length add(Length length) {
        double totalMagnitude = this.asStandardValue() + length.asStandardValue();
        return new Length(totalMagnitude, LengthUnit.standardUnit());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Length length = (Length) o;
        return Double.compare(length.value, value) == 0 &&
                unit == length.unit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, unit);
    }
}
