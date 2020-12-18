package measurement.quantity;

import measurement.units.VolumeUnit;

import java.util.Objects;

public class Volume extends AddableQuantity<VolumeUnit>{
    private final VolumeUnit standardUnit;

    public Volume(double magnitude, VolumeUnit unit) {
        super(magnitude, unit, Volume::new);
        this.standardUnit = VolumeUnit.LITER;
    }

    @Override
    protected VolumeUnit getStandardUnit() {
        return this.standardUnit;
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
