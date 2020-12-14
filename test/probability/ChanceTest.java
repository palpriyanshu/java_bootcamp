package probability;

import org.junit.Test;

import static org.junit.Assert.*;

public class ChanceTest {
    @Test
    public void shouldCalculateChanceOfGettingTailsWhenFlippingOneCoin() {
        Chance chanceOfNotGettingTail = new Chance(0.5);
        Chance chanceOfGettingTail = new Chance(0.5);
        assertEquals(chanceOfGettingTail, chanceOfNotGettingTail.not());
    }

    @Test
    public void shouldCalculateChanceOfGettingBothTailsWhenFlippingTwoCoin() {
        Chance chanceOfGettingTailForOneCoin = new Chance(0.5);
        Chance chanceOfGettingTwoTailsForTwoCoins = chanceOfGettingTailForOneCoin.and(chanceOfGettingTailForOneCoin);
        Chance expected = new Chance(0.25);
        assertEquals(expected, chanceOfGettingTwoTailsForTwoCoins);
    }

    @Test
    public void shouldCalculateChanceOfGettingAtLeastOneTailsWhenFlippingTwoCoin() {
        Chance chanceOfGettingTailForOneCoin = new Chance(0.5);
        Chance chanceOfGettingAtLeastOneTailsForTwoCoins = chanceOfGettingTailForOneCoin.or(chanceOfGettingTailForOneCoin);
        Chance expected = new Chance(0.75);
        assertEquals(expected, chanceOfGettingAtLeastOneTailsForTwoCoins);
    }
}
