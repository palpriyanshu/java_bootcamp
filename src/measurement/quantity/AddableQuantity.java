package measurement.quantity;

import measurement.units.Unit;

public abstract class AddableQuantity<U extends Unit> extends Quantity<U> {

    public AddableQuantity(double magnitude, U unit) {
        super(magnitude, unit);
    }

    public abstract AddableQuantity<U> add(AddableQuantity<U> quantity);
}
