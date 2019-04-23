package entity;

public class Place {
    private String placeId;
    private Boolean haveCar;
    private Car car;

    public Place(String placeId, Boolean haveCar, Car car) {
        this.placeId = placeId;
        this.haveCar = haveCar;
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public Boolean getHaveCar() {
        return haveCar;
    }

    public void setHaveCar(Boolean haveCar) {
        this.haveCar = haveCar;
    }
}
