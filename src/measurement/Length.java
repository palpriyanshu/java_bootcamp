package measurement;

import java.util.Objects;

public class Length {

    private final double value;
    private final Unit unit;

    public Length(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    private double asStandardValue() {
        return this.unit.calculateStandardValue(this.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Length length = (Length) o;
        double thisAsStandard = this.asStandardValue();
        double otherAsStandard = length.asStandardValue();

        return thisAsStandard == otherAsStandard;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.asStandardValue());
    }
}
