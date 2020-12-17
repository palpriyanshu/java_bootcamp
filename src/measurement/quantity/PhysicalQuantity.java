package measurement.quantity;

import measurement.exception.UnitCategoryMismatch;
import measurement.units.Unit;

import java.util.Objects;

public class PhysicalQuantity {
    private final double magnitude;
    private final Unit unit;

    public PhysicalQuantity(double magnitude, Unit unit) {
        this.magnitude = magnitude;
        this.unit = unit;
    }

    private boolean isNotOfSameCategory(Unit otherUnit){
        return otherUnit.getClass() != unit.getClass();
    }

    public boolean isEquivalent(PhysicalQuantity quantity) {
        if(isNotOfSameCategory(quantity.unit)) return false;

        double otherAsBase = quantity.unit.convertToBase(quantity.magnitude);
        double thisAsBase = this.unit.convertToBase(this.magnitude);
        return otherAsBase == thisAsBase;
    }

    public PhysicalQuantity add(PhysicalQuantity quantity, Unit standardUnit) throws UnitCategoryMismatch {
        if(isNotOfSameCategory(quantity.unit)) throw new UnitCategoryMismatch();

        double thisAsBase = this.unit.convertToBase(this.magnitude);
        double otherAsBase = quantity.unit.convertToBase(quantity.magnitude);

        double totalMagnitude = this.round(thisAsBase + otherAsBase);
        return new PhysicalQuantity(standardUnit.convertFromBase(totalMagnitude), standardUnit);
    }

    private double round(double value){
        return Math.round(value * 100.0) / 100.0 ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhysicalQuantity that = (PhysicalQuantity) o;
        return Double.compare(that.magnitude, magnitude) == 0 && Objects.equals(unit, that.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(magnitude, unit);
    }
}
