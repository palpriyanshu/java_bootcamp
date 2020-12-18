package measurement.quantity;

import measurement.units.LengthUnit;

import java.util.Objects;

public class Length extends Quantity<LengthUnit> {
    private final LengthUnit standardUnit;

    public Length(double magnitude, LengthUnit unit) {
        super(magnitude, unit);
        this.standardUnit = LengthUnit.INCH;
    }

    public Length add(Length length) {
        double totalMagnitude = this.asBaseValue() + length.asBaseValue();
        double valueInStandardUnit = this.standardUnit.convertFromBase(totalMagnitude);
        return new Length(this.round(valueInStandardUnit), this.standardUnit);
    }

    private double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Length length = (Length) o;
        return standardUnit == length.standardUnit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), standardUnit);
    }
}
