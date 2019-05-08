import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParkingLotBoyTest {
    @Test
    public void one_parking_no_places_tow_parking_have_empty_parking_space_should_return_one_parking_ticket() throws BusinessException {
        ParkingLotBoy parkingLotBoy = initParkingLogBoss();
        Car car = new Car("陕A-66666");

        Assert.assertEquals(parkingLotBoy.park(car).toString(), "------车票------\n" +
                "编号：1\n" +
                "车牌号：陕A-66666\n");
    }

    @Test
    public void have_one_ticket_should_return_one_car() throws BusinessException {
        ParkingLotBoy parkingLotBoy = initParkingLogBoss();
        Ticket ticket = new Ticket(1, "陕A-55555");

        Assert.assertEquals(parkingLotBoy.pickUp(ticket).toString(), "车牌号：陕A-55555");

    }

    @Test(expected = BusinessException.class)
    public void have_error_ticket_should_return_null() throws BusinessException {
        ParkingLotBoy parkingLotBoy = initParkingLogBoss();
        parkingLotBoy.pickUp(new Ticket(2, "陕A-66666"));
    }

    private ParkingLotBoy initParkingLogBoss() {
        ParkingLotBoy parkingLotBoy = new ParkingLotBoy();
        List<ParkingLot> parkingLots = new ArrayList<>();
        List<String> places = new ArrayList(Arrays.asList("陕A-55555"));
        parkingLots.add(new ParkingLot(1, places));
        parkingLots.add(new ParkingLot(1));
        parkingLotBoy.setParkingLots(parkingLots);
        return parkingLotBoy;
    }


}
