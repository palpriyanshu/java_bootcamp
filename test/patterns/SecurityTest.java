package patterns;

import org.junit.Test;

import static org.junit.Assert.*;

public class SecurityTest {
    @Test
    public void shouldGetNextParkingPlot() {
        Security security = new Security(5);
        assertEquals(1, security.nextParkingPlot());
    }
}