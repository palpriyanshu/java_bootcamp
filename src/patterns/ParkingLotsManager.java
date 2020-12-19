package patterns;

public class ParkingLotsManager {
    private final ParkingLot[] parkingLots;

    public ParkingLotsManager(ParkingLot[] parkingLots) {
        this.parkingLots = parkingLots;
    }

    public ParkingLotStatus park() throws NoParkingLotAvailable {
        ParkingLot availableParkingLot = this.findAvailableParkingLot();
        return availableParkingLot.park();
    }

    private ParkingLot findAvailableParkingLot() throws NoParkingLotAvailable {
        for (ParkingLot parkingLot : this.parkingLots) {
            if(!(parkingLot.isFull())){
                return parkingLot;
            }
        }
        throw new NoParkingLotAvailable();
    }

}

