package measurement.quantity;

import measurement.units.Unit;

public abstract class AddableQuantity<U extends Unit> extends Quantity<U> {
    private final QuantityCreator<U> creator;

    public AddableQuantity(double magnitude, U unit, QuantityCreator<U> creator) {
        super(magnitude, unit);
        this.creator = creator;
    }

    public AddableQuantity<U> add(AddableQuantity<U> quantity){
        double totalMagnitude = this.asBaseValue() + quantity.asBaseValue();
        double valueInStandardUnit = this.getStandardUnit().convertFromBase(totalMagnitude);
        return creator.create(valueInStandardUnit, this.getStandardUnit());
    }

    protected abstract U getStandardUnit();
}
