package measurement.quantity;

import measurement.units.LengthUnit;

import java.util.Objects;

public class Length extends AddableQuantity<LengthUnit> {
    private final LengthUnit standardUnit;

    public Length(double magnitude, LengthUnit unit) {
        super(magnitude, unit);
        this.standardUnit = LengthUnit.INCH;
    }

    @Override
    public AddableQuantity<LengthUnit> add(AddableQuantity<LengthUnit> quantity) {
        double totalMagnitude = this.asBaseValue() + quantity.asBaseValue();
        double valueInStandardUnit = this.standardUnit.convertFromBase(totalMagnitude);
        return new Length(valueInStandardUnit, this.standardUnit);
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
