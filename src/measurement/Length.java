package measurement;

import java.util.Objects;

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

    public Length add(Length length) throws DifferentUnitsException {
        if(this.unit != length.unit){
            throw new DifferentUnitsException(this.unit, length.unit);
        }
        return new Length(this.value + length.value, this.unit);
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
