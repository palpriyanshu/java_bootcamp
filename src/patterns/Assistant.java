package patterns;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class Assistant {
    private HashMap<ParkingLot, ParkingLotStatus> parkingLots = new HashMap<>();

    public Assistant(ParkingLot[] parkingArea) {
       Arrays.stream(parkingArea).forEach((parkingLot)-> parkingLots.put(parkingLot, ParkingLotStatus.AVAILABLE));
    }

    public void updateDisplay(ParkingLot parkingLot) {
        this.parkingLots.replace(parkingLot, ParkingLotStatus.FULL);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Assistant assistant = (Assistant) o;
        return Objects.equals(parkingLots, assistant.parkingLots);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parkingLots);
    }
}
