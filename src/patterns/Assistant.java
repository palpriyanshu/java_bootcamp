package patterns;

import java.util.HashMap;

public class Assistant implements ParkingLotSpectator {
    private final HashMap<ParkingLot, ParkingLotStatus> parkingLots ;

    public Assistant() {
        this.parkingLots = new HashMap<>();
    }

    @Override
    public void update(ParkingLot parkingLot, int occupancyStatus) {
        this.parkingLots.replace(parkingLot, ParkingLotStatus.FULL);
    }

    public void assign(ParkingLot parkingLot) {
        parkingLot.addSpectator(this,100);
        parkingLots.put(parkingLot, ParkingLotStatus.AVAILABLE);
    }

    @Override
    public String toString() {
        return "Assistant{" +
                "parkingLots=" + parkingLots +
                '}';
    }
}
