package probability;

import java.util.Objects;

public class Chance {
    private final double chanceValue;

    public Chance(double chanceValue) {
        this.chanceValue = chanceValue;
    }

    public Chance not() {
        return new Chance(1 - this.chanceValue);
    }

    public Chance and(Chance other) {
        return new Chance(this.chanceValue * other.chanceValue);
    }

    public Chance or(Chance other) {
        Chance notOfThis = this.not();
        Chance notOfOther = other.not();
        Chance notThisAndNotOther = notOfThis.and(notOfOther);
        return notThisAndNotOther.not();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chance chance = (Chance) o;
        return Double.compare(chance.chanceValue, chanceValue) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(chanceValue);
    }

}
