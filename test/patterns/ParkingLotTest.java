package patterns;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParkingLotTest {
    @Test
    public void shouldParkWhenSlotsAreAvailable()  {
        ParkingLot parkingLot = new ParkingLot(2);
        Assistant assistant = new Assistant();
        parkingLot.addSpectator(assistant::update, 100);
        assistant.assign(parkingLot);
        assertTrue(parkingLot.park());
    }

    @Test
    public void shouldNotParkWhenSlotsAreNotAvailable()  {
        ParkingLot parkingLot = new ParkingLot(1);
        Assistant assistant = new Assistant();
        parkingLot.addSpectator(assistant::update, 100);
        assistant.assign(parkingLot);
        parkingLot.park();
        assertFalse(parkingLot.park());
    }

    @Test
    public void shouldNotifyManagerWhenLotIs80PercentFull()  {
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.park();

    }

}