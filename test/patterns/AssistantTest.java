package patterns;

import org.junit.Test;

import static org.junit.Assert.*;

public class AssistantTest {
    @Test
    public void shouldDisplayParkingLot() {
        ParkingLot[] parkingLots = {new ParkingLot(1)};
        Assistant assistant = new Assistant(parkingLots);
        assistant.updateDisplay(parkingLots[0]);
    }
}