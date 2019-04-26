import java.util.ArrayList;
import java.util.List;

public class ParkingLogBoss {
    private List<ParkingLog> parkingLogs = new ArrayList<>();

    public List<ParkingLog> getParkingLogs() {
        return parkingLogs;
    }

    public void setParkingLogs(List<ParkingLog> parkingLogs) {
        this.parkingLogs = parkingLogs;
    }

    public Ticket carParking(Car car) {
        for (ParkingLog parkingLog : parkingLogs) {
            if (parkingLog.getPlaces().size() < parkingLog.getParkingSize()) {
                return parkingLog.carParking(car);
            }
        }
        return null;
    }

    public Car pickUp(Ticket ticket) {
        for (ParkingLog parkingLog : parkingLogs) {
            return parkingLog.pickUp(ticket);
        }
        return null;
    }

}
