package measurement;

public enum VolumeUnit {
    LITER(1), GALLON(3.78);

    private double valueInLiters;

    VolumeUnit(double valueInLiters) {
        this.valueInLiters = valueInLiters;
    }

    public double calculateStandardValue(double value) {
        return value * this.valueInLiters;
    }

    public double convertTo(double value, VolumeUnit unit) {
        double baseMagnitude = this.calculateStandardValue(value);
        return baseMagnitude / unit.valueInLiters;
    }
}
