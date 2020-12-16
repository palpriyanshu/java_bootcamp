package measurement.quantity;

import measurement.units.VolumeUnit;

import java.util.Objects;

public class Volume {
    private final double value;
    private final VolumeUnit unit;

    public Volume(double value, VolumeUnit unit) {

        this.value = value;
        this.unit = unit;
    }

    public boolean isEquivalent(Volume volume) {
        double thisAsStandard = this.asStandardValue();
        double otherAsStandard = volume.asStandardValue();

        return thisAsStandard == otherAsStandard;
    }

    private double asStandardValue() {
        return this.unit.convertToBaseValue(this.value);
    }

    public Volume add(Volume volume) {
        final VolumeUnit STANDARD_UNIT = VolumeUnit.LITER;
        double thisAsStandard = this.unit.convertTo(this.value, STANDARD_UNIT);
        double otherAsStandard = volume.unit.convertTo(volume.value, STANDARD_UNIT);
        double totalMagnitude = this.round(thisAsStandard + otherAsStandard);
        return new Volume(totalMagnitude, STANDARD_UNIT);
    }

    private double round(double value){
        return Math.round(value * 100.0) / 100.0 ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Volume volume = (Volume) o;
        return Double.compare(volume.value, value) == 0 &&
                unit == volume.unit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, unit);
    }
}
