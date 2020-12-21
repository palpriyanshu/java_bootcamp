package patterns;

public enum ParkingLotStatus {
    FULL,
    AVAILABLE;

    public boolean isAvailable() {
        return this == AVAILABLE;
    }
}
