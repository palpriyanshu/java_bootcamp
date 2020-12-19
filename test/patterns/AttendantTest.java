package patterns;

import org.junit.Test;

public class AttendantTest {

    @Test
    public void shouldBeAbleToParkTheCar() {
        ParkingLot[] parkingLots = {new ParkingLot(2), new ParkingLot(2)};
        Attendant attendant = new Attendant(parkingLots);
        attendant.parkCar();
    }
}
