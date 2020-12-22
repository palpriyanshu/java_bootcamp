package patterns;

import java.util.HashMap;

public class Assistant implements ParkingLotSpectator {
    private final HashMap<ParkingLot, ParkingLotStatus> parkingLots ;

    public Assistant(HashMap<ParkingLot, ParkingLotStatus> parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
    public void notify(ParkingLot parkingLot, double occupancyStatus) {
        this.parkingLots.replace(parkingLot, ParkingLotStatus.FULL);
    }

    @Override
    public String toString() {
        return "Assistant{" +
                "parkingLots=" + parkingLots +
                '}';
    }
}
