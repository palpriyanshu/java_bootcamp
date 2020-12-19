package patterns;

import java.util.Arrays;

public class ParkingLot {
    private int occupiedPlots;
    private PlotStatus[] plots;

    public ParkingLot(int totalPlots) {
        this.plots = new PlotStatus[totalPlots];
        Arrays.fill(this.plots, PlotStatus.EMPTY);
        this.occupiedPlots = 0;
    }

    public int park() throws LotNotAvailableException {
        if (this.occupiedPlots == this.plots.length) {
            throw new LotNotAvailableException();
        }
        this.plots[this.occupiedPlots++] = PlotStatus.OCCUPIED;
        return this.occupiedPlots;
    }

    public boolean isLotFull() {
        return this.occupiedPlots == this.plots.length;
    }
}
