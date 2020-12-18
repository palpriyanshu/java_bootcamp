package measurement.quantity;

import measurement.units.Unit;

import java.util.Objects;

public abstract class Quantity<U extends Unit> {
    private final double magnitude;
    private final U unit;

    public Quantity(double magnitude, U unit) {
        this.magnitude = magnitude;
        this.unit = unit;
    }

    public boolean isEquivalent(Quantity<U> quantity) {
        return this.asBaseValue() == quantity.asBaseValue();
    }

    public double asBaseValue() {
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
        return Double.compare(round(quantity.magnitude), round(this.magnitude)) == 0 &&
                Objects.equals(this.unit, quantity.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(magnitude, unit);
    }
}
