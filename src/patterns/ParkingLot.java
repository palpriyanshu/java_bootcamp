package patterns;

import java.util.HashMap;

public class ParkingLot {
    private int occupiedPlots;
    private final int totalSlots;
    private HashMap<ParkingLotSpectator, Integer> parkingLotSpectators = new HashMap<>();

    public ParkingLot(int totalPlots) {
        this.totalSlots = totalPlots;
        this.occupiedPlots = 0;
    }

    public boolean park() {
        if (this.isFull()) {
            return false;
        }
        this.occupiedPlots += 1;

        this.notifySpectator();
        return true;
    }

    public void addSpectator(ParkingLotSpectator parkingLotSpectator, int occupiedStatus) {
        this.parkingLotSpectators.put(parkingLotSpectator, occupiedStatus);

    }

    private boolean isFull() { return this.occupiedPlots == this.totalSlots; }

    private void notifySpectator() {
        for (ParkingLotSpectator parkingLotSpectator : parkingLotSpectators.keySet()) {
            int occupiedStatusInPercent = parkingLotSpectators.get(parkingLotSpectator);
            if(occupiedStatusInPercent == this.getCurrentOccupiedStatus()){
                parkingLotSpectator.update(this, 100);
            }
        }
    }

    private int getCurrentOccupiedStatus() {
        return (this.occupiedPlots / this.totalSlots) * 100;
    }

    @Override
    public String toString() {
        return "ParkingLot{" +
                "occupiedPlots=" + occupiedPlots +
                ", totalSlots=" + totalSlots +
                '}';
    }

}
