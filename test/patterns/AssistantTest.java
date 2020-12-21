package patterns;

import org.junit.Test;

import static org.junit.Assert.*;

public class AssistantTest {
    @Test
    public void shouldParkInAnyAvailableParkingLot() {
        Assistant assistant = new Assistant();
        assistant.assign(new ParkingLot(2));
        assertTrue(assistant.park());
    }
}
