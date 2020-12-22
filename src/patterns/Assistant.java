package patterns;

import java.util.HashMap;
import java.util.HashSet;

public class Assistant implements ParkingLotSpectator {
    private final HashMap<ParkingLot, ParkingLotStatus> parkingLots ;

    public Assistant() {
        this.parkingLots = new HashMap<>();
    }

    @Override
    public void notify(ParkingLot parkingLot, double occupancyStatus) {
        this.parkingLots.replace(parkingLot, ParkingLotStatus.FULL);
    }

    public void assign(ParkingLot parkingLot) {
        HashSet<Double> occupancyStatus = new HashSet<>();
        occupancyStatus.add(100.0);
        parkingLot.addSpectator(this, occupancyStatus);
        parkingLots.put(parkingLot, ParkingLotStatus.AVAILABLE);
    }

    @Override
    public String toString() {
        return "Assistant{" +
                "parkingLots=" + parkingLots +
                '}';
    }
}
