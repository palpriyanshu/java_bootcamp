package measurement.units;

public enum VolumeUnit implements Unit {
    LITER(1), GALLON(3.78);

    private final double valueInLiters;

    VolumeUnit(double valueInLiters) {
        this.valueInLiters = valueInLiters;
    }

    @Override
    public double convertToBaseValue(double value) {
        return value * this.valueInLiters;
    }

    @Override
    public double convertTo(double value, Unit unit) {
        VolumeUnit volumeUnit = (VolumeUnit) unit;
        double baseMagnitude = this.convertToBaseValue(value);
        return baseMagnitude / volumeUnit.valueInLiters;
    }
}
