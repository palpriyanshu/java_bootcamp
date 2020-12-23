package patterns;

import java.util.HashMap;
import java.util.HashSet;

public class ParkingLot {
    private int occupiedPlots;
    private final int totalSlots;
    private final HashMap<ParkingLotStatus, HashSet<ParkingLotSpectator>> parkingLotSpectators = new HashMap<>();

    public ParkingLot(int totalPlots) {
        this.totalSlots = totalPlots;
        this.occupiedPlots = 0;
        for (ParkingLotStatus key : ParkingLotStatus.values()) {
            parkingLotSpectators.put(key, new HashSet<>());
        }
    }

    public boolean park() {
        if (this.isFull()) {
            return false;
        }
        this.occupiedPlots++;
        this.notifySpectator();
        return true;
    }

    public void addSpectator(ParkingLotSpectator parkingLotSpectator, ParkingLotStatus lotStatus) {
        this.parkingLotSpectators.get(lotStatus).add(parkingLotSpectator);
    }

    private boolean isFull() {
        return this.occupiedPlots == this.totalSlots;
    }

    private void notifySpectator() {
        ParkingLotStatus currentOccupiedStatus = this.getCurrentOccupiedStatus();
        HashSet<ParkingLotSpectator> spectators = this.parkingLotSpectators.get(currentOccupiedStatus);
        for (ParkingLotSpectator spectator : spectators) {
            spectator.notify(this, currentOccupiedStatus);
        }
    }

    private ParkingLotStatus getCurrentOccupiedStatus() {
        double statusInPercentage = ((double) this.occupiedPlots) / this.totalSlots * 100;
        if(statusInPercentage == 80.0) return ParkingLotStatus.EIGHTY_PERCENT_FULL;
        if(statusInPercentage == 100.0) return ParkingLotStatus.FULL;
        return ParkingLotStatus.VACANT;

    }

    @Override
    public String toString() {
        return "ParkingLot{" +
                "occupiedPlots=" + occupiedPlots +
                ", totalSlots=" + totalSlots +
                '}';
    }

}
