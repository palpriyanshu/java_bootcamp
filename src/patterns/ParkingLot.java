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
        if(this.occupiedPlots == this.plots.length) {
            throw new LotNotAvailableException();
        }
        this.plots[this.occupiedPlots] = PlotStatus.OCCUPIED;
        this.occupiedPlots++;
        return this.occupiedPlots;
    }

    public boolean isLotFull(){
        for (PlotStatus plot : this.plots) {
            if(plot == PlotStatus.EMPTY){
                return false;
            }
        }
        return true;
    }
}
