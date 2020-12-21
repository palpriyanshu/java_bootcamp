package patterns;

public class ParkingLot {
    private int occupiedPlots;
    private int totalSlots;
    private Assistant assistant;

    public ParkingLot(int totalPlots) {
        this.totalSlots = totalPlots;
        this.occupiedPlots = 0;
    }

    public boolean park() {
        this.occupiedPlots++;
        if (this.isFull()) {
            this.notifyAssistant();
            return true;
        }
        return false;
    }

    private boolean isFull() {
        return this.occupiedPlots == this.totalSlots;
    }

    private void notifyAssistant() {
        assistant.update(this);
    }

    public void addAssistant(Assistant assistant) {
        this.assistant = assistant;
    }


    @Override
    public String toString() {
        return "ParkingLot{" +
                "occupiedPlots=" + occupiedPlots +
                ", totalSlots=" + totalSlots +
                '}';
    }
}
