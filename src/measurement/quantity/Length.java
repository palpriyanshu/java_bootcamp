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

    public boolean isEquivalent(Length length) {
        double otherAsThis = length.unit.convertTo(length.value, this.unit);
        return this.value == otherAsThis;
    }

    public Length add(Length length) {
        LengthUnit standardUnit = LengthUnit.INCH;
        double thisAsStandard = this.unit.convertTo(this.value, standardUnit);
        double otherAsStandard = length.unit.convertTo(length.value, standardUnit);
        double totalMagnitude = this.round(thisAsStandard + otherAsStandard);
        return new Length(totalMagnitude, standardUnit);
    }

    private double round(double value){
        return Math.round(value * 100.0) / 100.0 ;
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
