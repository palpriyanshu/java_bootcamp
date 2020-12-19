package patterns;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParkingLotTest {
    @Test
    public void shouldParkAtNextParkingPlot() throws LotNotAvailableException {
        ParkingLot parkingLot = new ParkingLot(2);
        assertEquals(1, parkingLot.park());
    }

    @Test
    public void shouldThrowLotNotAvailableExceptionWhenPlotIsNotAvailable() throws LotNotAvailableException {
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.park();
        assertThrows(LotNotAvailableException.class, parkingLot::park);
    }
}