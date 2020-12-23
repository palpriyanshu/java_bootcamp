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

        parkingLot.addSpectator(assistant, ParkingLotStatus.FULL);
        parkingLot.park();

        verify(assistant).notify(parkingLot, ParkingLotStatus.FULL);
    }

    @Test
    public void shouldNotifyAttendantWhenParkingLotIsFull() {
        ParkingLotSpectator attendant = mock(ParkingLotSpectator.class);
        ParkingLot parkingLot = new ParkingLot(1);

        parkingLot.addSpectator(attendant, ParkingLotStatus.FULL);
        parkingLot.park();

        verify(attendant).notify(parkingLot, ParkingLotStatus.FULL);
    }

    @Test
    public void shouldNotifyManagerWhenParkingLotIs80Percent() {
        ParkingLotSpectator manager = mock(ParkingLotSpectator.class);
        ParkingLot parkingLot = new ParkingLot(5);

        parkingLot.addSpectator(manager, ParkingLotStatus.ALMOST_FULL);
        parkingLot.park();
        parkingLot.park();
        parkingLot.park();
        parkingLot.park();

        verify(manager).notify(parkingLot, ParkingLotStatus.ALMOST_FULL);
    }

    @Test
    public void shouldNotifyAssistantWhenParkingLotIsLessOrEqualTo20PercentFull() {
        Assistant assistant = mock(Assistant.class);
        ParkingLot parkingLot = new ParkingLot(10);

        parkingLot.addSpectator(assistant, ParkingLotStatus.ALMOST_VACANT);
        parkingLot.park();

        verify(assistant).notify(parkingLot, ParkingLotStatus.ALMOST_VACANT);
    }
}