package comparison;

public class Length {

    private final double value;
    private final Unit unit;

    public Length(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public Comparison compareWith(Length anotherLength) {
        double thisAsStandard = this.asStandardValue();
        double otherAsStandard = anotherLength.asStandardValue();

        if(thisAsStandard == otherAsStandard) return Comparison.EQUAL;
        if(thisAsStandard > otherAsStandard) return Comparison.GREATER;
        return Comparison.LESSER;
    }

    private double asStandardValue() {
        return this.unit.asStandard(this.value);
    }
}
