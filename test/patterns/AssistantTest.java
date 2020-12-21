package patterns;

import org.junit.Test;

import static org.junit.Assert.*;

public class AssistantTest {
    @Test
    public void shouldParkInAnyAvailableParkingLot() {
        ParkingLot[] parkingLots = {new ParkingLot(1)};
        Assistant assistant = new Assistant(parkingLots);
        parkingLots[0].addAssistant(assistant);
        assertTrue(assistant.park());
    }
}