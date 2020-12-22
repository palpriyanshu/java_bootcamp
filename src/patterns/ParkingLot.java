package patterns;

public class ParkingLot {
    private int occupiedPlots;
    private final int totalSlots;
    private Spectator spectator;

    public ParkingLot(int totalPlots) {
        this.totalSlots = totalPlots;
        this.occupiedPlots = 0;
    }

    public boolean park() {
        if (this.isFull()) {
            return false;
        }
        this.occupiedPlots += 1;

        if (this.isFull()) {
            this.notifySpectator();
        }
        return true;
    }

    public void setSpectator(Spectator spectator) {
        this.spectator = spectator;
    }

    private boolean isFull() { return this.occupiedPlots == this.totalSlots; }

    private void notifySpectator() { spectator.update(this); }

    @Override
    public String toString() {
        return "ParkingLot{" +
                "occupiedPlots=" + occupiedPlots +
                ", totalSlots=" + totalSlots +
                '}';
    }

}
