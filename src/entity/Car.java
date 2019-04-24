package entity;

public class Car {
    private String plateNumber;

    public Car() {
    }

    public Car(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    @Override
    public String toString() {
        return "车牌号：" + plateNumber;
    }
}
