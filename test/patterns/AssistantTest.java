package patterns;

import org.junit.Test;

import static org.junit.Assert.*;

public class AssistantTest {
    @Test
    public void shouldParkInAnyAvailableParkingLot() {
        Assistant assistant = new Assistant(new ParkingLot(2));
        assertTrue(assistant.park());
    }

    @Test
    public void shouldNotParkWhenNoParkingLotAvailable() {
        Assistant assistant = new Assistant(new ParkingLot(1));
        assistant.park();
        assertFalse(assistant.park());
    }
}
