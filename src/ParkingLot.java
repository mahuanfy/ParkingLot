import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private int parkingSize;
    private List<String> plateNumbers = new ArrayList<>();
    private ParkingService parkingService = new ParkingService();

    public void setParkingService(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    public ParkingLot(int parkingSize) {
        this.parkingSize = parkingSize;
    }

    public ParkingLot(int parkingSize, List<String> plateNumbers) {
        this.parkingSize = parkingSize;
        this.plateNumbers = plateNumbers;
    }

    public int getParkingSize() {
        return parkingSize;
    }

    public List<String> getPlaces() {
        return plateNumbers;
    }

    public Ticket park(Car car) throws BusinessException {
        if (!haveVacantParkingSpaces()) {
            throw new BusinessException("停车失败...");
        }
        plateNumbers.add(car.getPlateNumber());

        return parkingService.createTicket(car.getPlateNumber());
    }

    private boolean haveVacantParkingSpaces() {
        return this.getPlaces().size() < this.parkingSize;
    }

    public Car pickUp(Ticket ticket) throws BusinessException {
        Car car = new Car();
        int size = plateNumbers.size();
        for (int i = 0; i < size; i++) {
            String place = plateNumbers.get(i);
            if (isCorrectTicket(ticket, place)) {
                plateNumbers.remove(place);
                car.setPlateNumber(ticket.getPlateNumber());
                return car;
            }
        }

        throw new BusinessException("取车失败..");
    }

    private boolean isCorrectTicket(Ticket ticket, String place) {
        return ticket.getPlateNumber().equals(place);
    }
}
