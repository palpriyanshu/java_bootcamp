package measurement.quantity;

import measurement.units.Unit;

import java.util.Objects;

public class Quantity<UNIT extends Unit> {
    private final double magnitude;
    private final UNIT unit;

    public Quantity(double magnitude, UNIT unit) {
        this.magnitude = magnitude;
        this.unit = unit;
    }

    public boolean isEquivalent(Quantity<UNIT> quantity) {
        return this.asBaseValue() == quantity.asBaseValue();
    }

    public Quantity<UNIT> add(Quantity<UNIT> quantity, UNIT standardUnit) {
        double totalMagnitude = this.round(this.asBaseValue() + quantity.asBaseValue());
        double valueInStandardUnit = standardUnit.convertFromBase(totalMagnitude);
        return new Quantity<>(valueInStandardUnit, standardUnit);
    }

    private double asBaseValue(){
        return this.unit.convertToBase(this.magnitude);
    }

    private double round(double value){
        return Math.round(value * 100.0) / 100.0 ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quantity<?> quantity = (Quantity<?>) o;
        return Double.compare(quantity.magnitude, magnitude) == 0 &&
                Objects.equals(unit, quantity.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(magnitude, unit);
    }
}
