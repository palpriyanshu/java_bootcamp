package patterns;

import java.util.HashMap;

public class Assistant implements Spectator{
    private HashMap<ParkingLot, ParkingLotStatus> parkingLots = new HashMap<>();

    public Assistant(ParkingLot parkingLot) {
        this.parkingLots.put(parkingLot, ParkingLotStatus.AVAILABLE);
    }

    @Override
    public void update(ParkingLot parkingLot) {
        this.parkingLots.replace(parkingLot, ParkingLotStatus.FULL);
    }

    public void assign(ParkingLot parkingLot) {
        parkingLot.setSpectator(this::update);
        parkingLots.put(parkingLot, ParkingLotStatus.AVAILABLE);
    }

    @Override
    public String toString() {
        return "Assistant{" +
                "parkingLots=" + parkingLots +
                '}';
    }
}
