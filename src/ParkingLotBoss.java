import java.util.ArrayList;
import java.util.List;

public class ParkingLotBoss {
    private List<ParkingLot> parkingLots = new ArrayList<>();

    public void setParkingLots(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getPlaces().size() < parkingLot.getParkingSize()) {
                return parkingLot.park(car);
            }
        }
        return null;
    }

    public Car pickUp(Ticket ticket) {
        for (ParkingLot parkingLot : parkingLots) {
            return parkingLot.pickUp(ticket);
        }
        return null;
    }

}
