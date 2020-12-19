package patterns;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParkingLotsManagerTest {

    @Test
    public void shouldBeAbleToParkTheCar() throws NoParkingLotAvailable {
        ParkingLot[] parkingLots = {new ParkingLot(2), new ParkingLot(2)};
        ParkingLotsManager manager = new ParkingLotsManager(parkingLots);
        assertEquals(ParkingLotStatus.AVAILABLE,manager.park() );
    }

    @Test
    public void shouldThrowNoAvailableParkingLot() throws NoParkingLotAvailable {
        ParkingLot[] parkingLots = {new ParkingLot(1)};
        ParkingLotsManager manager = new ParkingLotsManager(parkingLots);
        manager.park();
        assertThrows(NoParkingLotAvailable.class, () -> manager.park());
    }
}