package measurement.units;

public interface Unit {
    double convertTo(double value, Unit unit);
}
