package patterns;

import java.util.Arrays;

public class ParkingLot {
    private int occupiedPlots;
    private SlotStatus[] slots;

    public ParkingLot(int totalPlots) {
        this.slots = new SlotStatus[totalPlots];
        Arrays.fill(this.slots, SlotStatus.EMPTY);
        this.occupiedPlots = 0;
    }

    public int park() throws LotNotAvailableException {
        if (this.isFull()) {
            throw new LotNotAvailableException();
        }
        this.slots[this.occupiedPlots++] = SlotStatus.OCCUPIED;
        return this.occupiedPlots;
    }

    private boolean isFull() {
        return this.occupiedPlots == this.slots.length;
    }
}
