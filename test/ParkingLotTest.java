import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParkingLotTest {

    @Test
    public void have_empty_parking_space_should_return_one_parking_ticket() throws BusinessException {
        ParkingLot parkingLot = initParkingLog();
        Car car = new Car("陕A-66666");

        Assert.assertEquals(parkingLot.park(car).toString(), "------车票------\n" +
                "编号：1\n" +
                "车牌号：陕A-66666\n");
    }

    @Test(expected = BusinessException.class)
    public void no_have_parking_space_should_return_null() throws BusinessException {
        ParkingLot parkingLot = initPutOneCar();
        Car car1 = new Car("陕A-33333");
        parkingLot.park(car1);
    }

    @Test
    public void have_one_ticket_should_return_one_car() throws BusinessException {
        ParkingLot parkingLot = initPutOneCar();
        Ticket ticket = new Ticket(1, "陕A-55555");

        Assert.assertEquals(parkingLot.pickUp(ticket).toString(), "车牌号：陕A-55555");
    }

    @Test(expected = BusinessException.class)
    public void have_error_ticket_should_return_null() throws BusinessException {
        ParkingLot parkingLot = initPutOneCar();
        Ticket ticket = new Ticket(1, "陕A-88888");
        parkingLot.pickUp(ticket);
    }

    private ParkingLot initPutOneCar() {
        List<String> places = new ArrayList(Arrays.asList("陕A-55555"));
        return new ParkingLot(1, places);
    }

    private ParkingLot initParkingLog() {
        return new ParkingLot(3);
    }
}
