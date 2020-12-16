package measurement.units;

public interface Unit {
    double convertToBaseValue(double value);
    double convertTo(double value, Unit unit);
}
