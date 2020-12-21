package patterns;

public class ParkingLot {
    private int occupiedPlots;
    private int totalSlots;

    public ParkingLot(int totalPlots) {
        this.totalSlots = totalPlots;
        this.occupiedPlots = 0;
    }

    public ParkingLotStatus park()   {
        this.occupiedPlots++;
        if(this.isFull()){
            return ParkingLotStatus.FULL;
        }
        return ParkingLotStatus.AVAILABLE;
    }

    public boolean isFull() {
        return this.occupiedPlots == this.totalSlots;
    }

    @Override
    public String toString() {
        return "ParkingLot{" +
                "occupiedPlots=" + occupiedPlots +
                ", totalSlots=" + totalSlots +
                '}';
    }
}
