package measurement;

public class DifferentUnitsException extends Throwable {
    private final LengthUnit unit1;
    private final LengthUnit unit2;

    public DifferentUnitsException(LengthUnit unit1, LengthUnit unit2) {
        this.unit1 = unit1;
        this.unit2 = unit2;
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
