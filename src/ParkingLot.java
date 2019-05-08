import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private int parkingSize;
    private List<String> licenses = new ArrayList<>();

    public ParkingLot(int parkingSize) {
        this.parkingSize = parkingSize;
    }

    public ParkingLot(int parkingSize, List<String> licenses) {
        this.parkingSize = parkingSize;
        this.licenses = licenses;
    }

    public int getParkingSize() {
        return parkingSize;
    }

    public List<String> getPlaces() {
        return licenses;
    }

    public Ticket park(Car car) throws BusinessException {
        if (!haveVacantParkingSpaces()) {
            throw new BusinessException("停车失败...");
        }
        licenses.add(car.getPlateNumber());

        return new Ticket(this.getPlaces().size(), car.getPlateNumber());
    }

    private boolean haveVacantParkingSpaces() {
        return this.getPlaces().size() < this.parkingSize;
    }

    public Car pickUp(Ticket ticket) throws BusinessException {
        Car car = new Car();
        int size = licenses.size();
        for (int i = 0; i < size; i++) {
            String place = licenses.get(i);
            if (isCorrectTicket(ticket, place)) {
                licenses.remove(place);
                car.setPlateNumber(ticket.getLicensePlate());
                return car;
            }
        }

        throw new BusinessException("取车失败..");
    }

    private boolean isCorrectTicket(Ticket ticket, String place) {
        return ticket.getLicensePlate().equals(place);
    }
}
