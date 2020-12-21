package patterns;

import java.util.HashMap;

public class Assistant implements Spectator{
    private HashMap<ParkingLot, ParkingLotStatus> parkingLots;

    public Assistant() {
        this.parkingLots = new HashMap<>();
    }

    @Override
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

    public void assign(ParkingLot parkingLot) {
        parkingLot.addSpectator(this);
        parkingLots.put(parkingLot, ParkingLotStatus.AVAILABLE);
    }
}
