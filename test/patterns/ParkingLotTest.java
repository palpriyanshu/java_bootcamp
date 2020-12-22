package patterns;

import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ParkingLotTest {
    @Test
    public void shouldParkWhenSlotsAreAvailable() {
        ParkingLot parkingLot = new ParkingLot(1);
        assertTrue(parkingLot.park());
    }

    @Test
    public void shouldNotParkWhenSlotsAreNotAvailable() {
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.park();
        assertFalse(parkingLot.park());
    }

    @Test
    public void shouldNotifyAssistantWhenParkingLotIsFull() {
        Assistant assistant = mock(Assistant.class);
        ParkingLot parkingLot = new ParkingLot(1);
        HashSet<Double> occupancy = new HashSet<>();
        occupancy.add(100.0);
        parkingLot.addSpectator(assistant::notify, occupancy);
        parkingLot.park();

        verify(assistant).notify(parkingLot, 100.0);
    }

    @Test
    public void shouldNotifyAttendantWhenParkingLotIsFull() {
        ParkingLotSpectator attendant = mock(ParkingLotSpectator.class);
        ParkingLot parkingLot = new ParkingLot(1);
        HashSet<Double> occupancy = new HashSet<>();
        occupancy.add(100.0);
        parkingLot.addSpectator(attendant::notify, occupancy);
        parkingLot.park();

        verify(attendant).notify(parkingLot, 100.0);
    }

    @Test
    public void shouldNotifyManagerWhenParkingLotIs80Percent() {
        ParkingLotSpectator manager = mock(ParkingLotSpectator.class);
        ParkingLot parkingLot = new ParkingLot(5);
        HashSet<Double> occupancy = new HashSet<>();
        occupancy.add(80.0);
        parkingLot.addSpectator(manager::notify, occupancy);
        parkingLot.park();
        parkingLot.park();
        parkingLot.park();
        parkingLot.park();

        verify(manager).notify(parkingLot, 80.0);
    }
}