package patterns;

import java.util.HashMap;
import java.util.HashSet;

public class ParkingLot {
    private int occupiedPlots;
    private final int totalSlots;
    private final HashMap<ParkingLotSpectator, HashSet<Double>> parkingLotSpectators = new HashMap<>();

    public ParkingLot(int totalPlots) {
        this.totalSlots = totalPlots;
        this.occupiedPlots = 0;
    }

    public boolean park() {
        if (this.isFull()) {
            return false;
        }
        this.occupiedPlots++;
        this.notifySpectator();
        return true;
    }

    public void addSpectator(ParkingLotSpectator parkingLotSpectator, HashSet<Double> occupiedStatus) {
        this.parkingLotSpectators.put(parkingLotSpectator, occupiedStatus);

    }

    private boolean isFull() { return this.occupiedPlots == this.totalSlots; }

    private void notifySpectator() {
        for (ParkingLotSpectator parkingLotSpectator : parkingLotSpectators.keySet()) {
            HashSet<Double> occupiedStatusInPercent = parkingLotSpectators.get(parkingLotSpectator);
            double currentOccupiedStatus = this.getCurrentOccupiedStatus();
            if(occupiedStatusInPercent.contains(currentOccupiedStatus)) {
                parkingLotSpectator.notify(this, currentOccupiedStatus);
            }
        }
    }

    private double getCurrentOccupiedStatus() {
        return ((double) this.occupiedPlots) / this.totalSlots * 100;
    }

    @Override
    public String toString() {
        return "ParkingLot{" +
                "occupiedPlots=" + occupiedPlots +
                ", totalSlots=" + totalSlots +
                '}';
    }

}
