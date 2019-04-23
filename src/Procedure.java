import entity.Car;
import entity.Place;

import java.util.List;

public class Procedure {
    private ParkingData parkingData = new ParkingData();

    public String inputParking(Car car) {
        List<Place> places = parkingData.getPlaces();
        if (isFullPlace(places)) {
            return "Parking failure!";
        }
        String placeId = getPlaceTicket(places, car);
        return printPlaceTicket(car, placeId);
    }

    private String printPlaceTicket(Car car, String placeId) {
        return "------车票------\n" +
                "车牌号：" + car.getNumberPlates() +
                "\n停车号：" + placeId;
    }

    private String getPlaceTicket(List<Place> places, Car car) {
        String placeId = "";
        for (Place place : places) {
            if (!place.getHaveCar()) {
                placeId = place.getPlaceId();
                place.setHaveCar(true);
                place.setCar(car);
                break;
            }
        }
        return placeId;
    }

    private boolean isFullPlace(List<Place> places) {
        return places.stream().filter(place -> place.getHaveCar() == false).count() == 0;
    }

    public String outputParking(String placeId) {
        List<Place> places = parkingData.getPlaces();
        if (isCorrectTicket(placeId, places)) {
            return getCarByTicket(placeId, places);
        }
        return "No car found!";

    }

    private String getCarByTicket(String placeId, List<Place> places) {
        Car car = new Car();
        for (Place place : places) {
            if (place.getPlaceId().equals(placeId)) {
                car = place.getCar();
                place.setCar(null);
                place.setHaveCar(false);
                break;
            }
        }

        return "已取车：" + car.getNumberPlates();
    }

    private boolean isCorrectTicket(String placeId, List<Place> places) {
        return places.stream().anyMatch(place -> place.getPlaceId().equals(placeId) && place.getHaveCar());
    }
}
