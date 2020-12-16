package measurement.quantity;

import measurement.units.Unit;

public class PhysicalQuantity<U extends Unit> {
    private final double magnitude;
    private final U unit;

    public PhysicalQuantity(double magnitude, U unit) {
        this.magnitude = magnitude;
        this.unit = unit;
    }

    public boolean isEquivalent(PhysicalQuantity<U> volume) {
        double thisAsStandard = this.asStandardValue();
        double otherAsStandard = volume.asStandardValue();

        return thisAsStandard == otherAsStandard;
    }

    private double asStandardValue() {
        return this.unit.convertToBaseValue(this.magnitude);
    }
}
