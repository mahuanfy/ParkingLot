import java.util.ArrayList;
import java.util.List;

public class ParkingLotBoy {
    private List<ParkingLot> parkingLots = new ArrayList<>();

    public void setParkingLots(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) throws BusinessException {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getPlaces().size() < parkingLot.getParkingSize()) {
                return parkingLot.park(car);
            }
        }
        throw new BusinessException("停车失败...");
    }

    public Car pickUp(Ticket ticket) throws BusinessException {
        for (ParkingLot parkingLot : parkingLots) {
            return parkingLot.pickUp(ticket);
        }
        throw new BusinessException("取车失败..");
    }

}
