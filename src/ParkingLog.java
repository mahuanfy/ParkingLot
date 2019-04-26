import java.util.ArrayList;
import java.util.List;

public class ParkingLog {
    private int parkingSize;
    private List<String> places = new ArrayList<>();

    public ParkingLog(int parkingSize) {
        this.parkingSize = parkingSize;
    }

    public ParkingLog(int parkingSize, List<String> places) {
        this.parkingSize = parkingSize;
        this.places = places;
    }

    public int getParkingSize() {
        return parkingSize;
    }

    public List<String> getPlaces() {
        return places;
    }

    public Ticket carParking(Car car) {
        if (!haveVacantParkingSpaces()) {
            return null;
        }
        places.add(car.getPlateNumber());

        return new Ticket(this.getPlaces().size(), car.getPlateNumber());
    }

    private boolean haveVacantParkingSpaces() {
        return this.getPlaces().size() < this.parkingSize;
    }

    public Car pickUp(Ticket ticket) {
        Car car = new Car();
        int size = places.size();
        for (int i = 0; i < size; i++) {
            String place = places.get(i);
            if (isCorrectTicket(ticket, place)) {
                places.remove(place);
                car.setPlateNumber(ticket.getPlateNumber());
                return car;
            }
        }

        return null;
    }

    private boolean isCorrectTicket(Ticket ticket, String place) {
        return ticket.getPlateNumber().equals(place);
    }
}
