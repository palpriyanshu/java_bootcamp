package patterns;

import org.junit.Test;

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

        parkingLot.addSpectator(assistant::notify, ParkingLotStatus.FULL);
        parkingLot.park();

        verify(assistant).notify(parkingLot, ParkingLotStatus.FULL);
    }

    @Test
    public void shouldNotifyAttendantWhenParkingLotIsFull() {
        ParkingLotSpectator attendant = mock(ParkingLotSpectator.class);
        ParkingLot parkingLot = new ParkingLot(1);

        parkingLot.addSpectator(attendant::notify, ParkingLotStatus.FULL);
        parkingLot.park();

        verify(attendant).notify(parkingLot, ParkingLotStatus.FULL);
    }

    @Test
    public void shouldNotifyManagerWhenParkingLotIs80Percent() {
        ParkingLotSpectator manager = mock(ParkingLotSpectator.class);
        ParkingLot parkingLot = new ParkingLot(5);

        parkingLot.addSpectator(manager::notify, ParkingLotStatus.EIGHTY_PERCENT_FULL);
        parkingLot.park();
        parkingLot.park();
        parkingLot.park();
        parkingLot.park();

        verify(manager).notify(parkingLot, ParkingLotStatus.EIGHTY_PERCENT_FULL);
    }
}