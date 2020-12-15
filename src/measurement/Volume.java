package measurement;

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
        return this.unit.calculateStandardValue(this.value);
    }
}
