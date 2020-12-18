package measurement.quantity;

import measurement.units.Unit;

public interface QuantityCreator<U extends Unit> {
    AddableQuantity<U> create(double magnitude, U unit);
}
