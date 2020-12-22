package patterns;

import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ParkingLotTest {
    @Test
    public void shouldParkWhenSlotsAreAvailable()  {
        ParkingLot parkingLot = new ParkingLot(1);
        assertTrue(parkingLot.park());
    }

    @Test
    public void shouldNotParkWhenSlotsAreNotAvailable()  {
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.park();
        assertFalse(parkingLot.park());
    }

    @Test
    public void shouldNotifyAssistantWhenParkingLotIsFull()  {
        Assistant assistant = mock(Assistant.class);
        ParkingLot parkingLot = new ParkingLot(1);
        assistant.assign(parkingLot);
        HashSet<Double> occupancy = new HashSet<>();
        occupancy.add(100.0);
        parkingLot.addSpectator(assistant::notify, occupancy);
        assertTrue(parkingLot.park());

        verify(assistant).notify(parkingLot, 100.0);
    }

}