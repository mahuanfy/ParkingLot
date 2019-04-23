import entity.Car;
import entity.Place;
import org.junit.Assert;
import org.junit.Test;

public class ProcedureTest {

    @Test
    public void have_one_parking_lot_should_return_one_parking_ticket() {
        ParkingData.places.add(new Place("POSITION-001", false, null));
        ParkingData.places.add(new Place("POSITION-002", true, new Car("陕A-11111")));
        ParkingData.places.add(new Place("POSITION-003", false, null));
        ParkingData.places.add(new Place("POSITION-004", true, new Car("陕A-22222")));
        ParkingData.places.add(new Place("POSITION-005", true, new Car("陕A-33333")));
        ParkingData.places.add(new Place("POSITION-006", false, null));
        Car car1 = new Car("陕A-88888");
        Car car2 = new Car("陕A-77777");
        Car car3 = new Car("陕A-66666");

        Procedure procedure = new Procedure();
        Assert.assertEquals(procedure.inputParking(car1), "------车票------\n" +
                "车牌号：陕A-88888\n" +
                "停车号：POSITION-001");
        Assert.assertEquals(procedure.inputParking(car2), "------车票------\n" +
                "车牌号：陕A-77777\n" +
                "停车号：POSITION-003");
        Assert.assertEquals(procedure.inputParking(car3), "------车票------\n" +
                "车牌号：陕A-66666\n" +
                "停车号：POSITION-006");
    }

    @Test
    public void no_have_parking_lot_should_return_parking_failure() {
        ParkingData.places.add(new Place("POSITION-001", true, new Car("陕A-88888")));
        ParkingData.places.add(new Place("POSITION-002", true, new Car("陕A-11111")));
        ParkingData.places.add(new Place("POSITION-003", true, new Car("陕A-77777")));
        ParkingData.places.add(new Place("POSITION-004", true, new Car("陕A-22222")));
        ParkingData.places.add(new Place("POSITION-005", true, new Car("陕A-33333")));
        ParkingData.places.add(new Place("POSITION-006", true, new Car("陕A-66666")));

        Procedure procedure = new Procedure();
        Car car = new Car("陕A-55555");
        Assert.assertEquals(procedure.inputParking(car), "Parking failure!");
    }

    @Test
    public void have_one_ticket_should_return_one_car(){
        ParkingData.places.add(new Place("POSITION-001", false, null));
        ParkingData.places.add(new Place("POSITION-002", true, new Car("陕A-11111")));
        ParkingData.places.add(new Place("POSITION-003", false, null));
        ParkingData.places.add(new Place("POSITION-004", true, new Car("陕A-22222")));
        ParkingData.places.add(new Place("POSITION-005", true, new Car("陕A-33333")));
        ParkingData.places.add(new Place("POSITION-006", false, null));

        String placeId = "POSITION-002";
        String placeId2 = "POSITION-003";
        Procedure procedure = new Procedure();
        Assert.assertEquals(procedure.outputParking(placeId), "已取车：陕A-11111");
        Assert.assertEquals(procedure.outputParking(placeId2), "No car found!");
    }
}
