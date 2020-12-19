package patterns;

public class Security {
    private int occupiedPlots;
    private int totalPlots;

    public Security(int totalPlots) {
        this.totalPlots = totalPlots;
        this.occupiedPlots = 0;
    }

    public int nextParkingPlot() {
        this.occupiedPlots++;
        return this.occupiedPlots;
    }
}
