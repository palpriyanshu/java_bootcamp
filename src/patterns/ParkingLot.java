package patterns;

public class ParkingLot {
    private int occupiedPlots;
    private int totalSlots;
    private Spectator spectator;

    public ParkingLot(int totalPlots) {
        this.totalSlots = totalPlots;
        this.occupiedPlots = 0;
    }

    public boolean park() {
        if (this.isFull()) {
            return false;
        }
        this.occupiedPlots++;
        if (this.isFull()) {
            notifySpectator();
        }
        return true;
    }

    private boolean isFull() {
        return this.occupiedPlots == this.totalSlots;
    }

    private void notifySpectator() {
        spectator.update(this);
    }

    public void addSpectator(Spectator spectator) {
        this.spectator = spectator;
    }

    @Override
    public String toString() {
        return "ParkingLot{" +
                "occupiedPlots=" + occupiedPlots +
                ", totalSlots=" + totalSlots +
                '}';
    }
}
