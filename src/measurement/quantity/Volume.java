package measurement.quantity;

import measurement.units.VolumeUnit;

import java.util.Objects;

public class Volume extends Quantity<VolumeUnit> {
    private final VolumeUnit standardUnit;

    public Volume(double magnitude, VolumeUnit unit) {
        super(magnitude, unit);
        this.standardUnit = VolumeUnit.LITER;
    }

    public Volume add(Volume volume) {
        double totalMagnitude = this.asBaseValue() + volume.asBaseValue();
        double valueInStandardUnit = this.standardUnit.convertFromBase(totalMagnitude);
        return new Volume(this.round(valueInStandardUnit), this.standardUnit);
    }

    private double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Volume volume = (Volume) o;
        return standardUnit == volume.standardUnit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), standardUnit);
    }
}
