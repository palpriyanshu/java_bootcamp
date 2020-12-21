package patterns;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class Assistant {
    private HashMap<ParkingLot, ParkingLotStatus> parkingLots = new HashMap<>();

    public Assistant(ParkingLot[] parkingArea) {
       Arrays.stream(parkingArea).forEach((parkingLot)-> parkingLots.put(parkingLot, ParkingLotStatus.AVAILABLE));
    }

    public void update(ParkingLot parkingLot) {
        this.parkingLots.replace(parkingLot, ParkingLotStatus.FULL);
    }

    public boolean park() {
        for (ParkingLot parkingLot : parkingLots.keySet()) {
           if(parkingLots.get(parkingLot).isAvailable()){
               return parkingLot.park();
           }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Assistant{" +
                "parkingLots=" + parkingLots +
                '}';
    }
}
