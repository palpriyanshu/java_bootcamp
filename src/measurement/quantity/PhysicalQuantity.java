package measurement.quantity;

import measurement.units.Unit;

import java.util.Objects;

public class PhysicalQuantity<U extends Unit> {
    private final double magnitude;
    private final U unit;

    public PhysicalQuantity(double magnitude, U unit) {
        this.magnitude = magnitude;
        this.unit = unit;
    }

    public boolean isEquivalent(PhysicalQuantity<U> quantity) {
        double otherAsThis = quantity.unit.convertTo(quantity.magnitude, this.unit);
        return this.magnitude == otherAsThis;
    }

    public PhysicalQuantity<U> add(PhysicalQuantity<U> quantity, U standardUnit) {
        double thisAsStandard = this.unit.convertTo(this.magnitude, standardUnit);
        double otherAsStandard = quantity.unit.convertTo(quantity.magnitude, standardUnit);
        double totalMagnitude = this.round(thisAsStandard + otherAsStandard);
        return new PhysicalQuantity(totalMagnitude, standardUnit);
    }

    private double round(double value){
        return Math.round(value * 100.0) / 100.0 ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhysicalQuantity<?> that = (PhysicalQuantity<?>) o;
        return Double.compare(that.magnitude, magnitude) == 0 &&
                Objects.equals(unit, that.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(magnitude, unit);
    }
}
