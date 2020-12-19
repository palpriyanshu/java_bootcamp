package patterns;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParkingLotTest {
    @Test
    public void shouldGetStatusOfParkingLotAsAvailableWhenSlotsAreAvailable()  {
        ParkingLot parkingLot = new ParkingLot(2);
        assertEquals(ParkingLotStatus.AVAILABLE, parkingLot.park());
    }

    @Test
    public void shouldGetStatusOfParkingLotAsFullWhenSlotsAreNotAvailable()  {
        ParkingLot parkingLot = new ParkingLot(1);
        assertEquals(ParkingLotStatus.FULL, parkingLot.park());
    }


}