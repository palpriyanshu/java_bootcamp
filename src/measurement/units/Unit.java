package measurement.units;

public interface Unit<U> {
    double convertToBaseValue(double value);
    double convertTo(double value, U unit);
}
