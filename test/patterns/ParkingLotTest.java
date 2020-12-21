package patterns;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParkingLotTest {
    @Test
    public void shouldParkWhenSlotsAreAvailable()  {
        ParkingLot parkingLot = new ParkingLot(2);
        Assistant assistant = new Assistant();
        parkingLot.addSpectator(assistant);
        assistant.assign(parkingLot);
        assertTrue(parkingLot.park());
    }

    @Test
    public void shouldNotParkWhenSlotsAreNotAvailable()  {
        ParkingLot parkingLot = new ParkingLot(1);
        Assistant assistant = new Assistant();
        parkingLot.addSpectator(assistant);
        assistant.assign(parkingLot);
        parkingLot.park();
        assertFalse(parkingLot.park());
    }

}