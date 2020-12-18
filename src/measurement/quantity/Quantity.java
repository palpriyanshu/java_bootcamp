package measurement.quantity;

import measurement.units.Unit;

import java.util.Objects;

public class Quantity<U extends Unit> {
    private final double magnitude;
    private final U unit;
    private U standardUnit;

    public Quantity(double magnitude, U unit) {
        this.magnitude = magnitude;
        this.unit = unit;
        this.standardUnit = unit;
    }

    public void setStandardUnit(U unit) {
        this.standardUnit = unit;
    }

    public boolean isEquivalent(Quantity<U> quantity) {
        return this.asBaseValue() == quantity.asBaseValue();
    }

    public Quantity<U> add(Quantity<U> quantity) {
        double totalMagnitude = this.asBaseValue() + quantity.asBaseValue();
        double valueInStandardUnit = this.standardUnit.convertFromBase(totalMagnitude);
        return new Quantity<>(this.round(valueInStandardUnit), this.standardUnit);
    }

    private double asBaseValue() {
        return this.unit.convertToBase(this.magnitude);
    }

    private double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quantity<?> quantity = (Quantity<?>) o;
        return Double.compare(quantity.magnitude, this.magnitude) == 0 &&
                Objects.equals(this.unit, quantity.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(magnitude, unit);
    }

    @Override
    public String toString() {
        return "Quantity{" +
                "magnitude=" + magnitude +
                ", unit=" + unit +
                ", standardUnit=" + standardUnit +
                '}';
    }
}
