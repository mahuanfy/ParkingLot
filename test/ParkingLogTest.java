import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParkingLogTest {

    @Test
    public void have_empty_parking_space_should_return_one_parking_ticket() {
        ParkingLog parkingLog = initParkingLog();
        Car car = new Car("陕A-66666");

        Assert.assertEquals(parkingLog.carParking(car).toString(), "------车票------\n" +
                "编号：1\n" +
                "车牌号：陕A-66666\n");
    }

    @Test
    public void no_have_parking_space_should_return_null() {
        ParkingLog parkingLog = initPutOneCar();
        Car car1 = new Car("陕A-33333");

        Assert.assertNull(parkingLog.carParking(car1));
    }

    @Test
    public void have_one_ticket_should_return_one_car() {
        ParkingLog parkingLog = initPutOneCar();
        Ticket ticket = new Ticket(1, "陕A-55555");

        Assert.assertEquals(parkingLog.pickUp(ticket).toString(), "车牌号：陕A-55555");
    }

    @Test
    public void have_error_ticket_should_return_null() {
        ParkingLog parkingLog = initPutOneCar();
        Ticket ticket = new Ticket(1, "陕A-88888");

        Assert.assertNull(parkingLog.pickUp(ticket));
    }

    private ParkingLog initPutOneCar() {
        List<String> places = new ArrayList(Arrays.asList("陕A-55555"));
        return new ParkingLog(1, places);
    }

    private ParkingLog initParkingLog() {
        return new ParkingLog(3);
    }
}
