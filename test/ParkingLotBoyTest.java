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

        Assert.assertEquals(parkingLotBoy.park(car).getPlateNumber(), "陕A-66666");
    }

    @Test
    public void have_one_ticket_should_return_one_car() throws BusinessException {
        ParkingLotBoy parkingLotBoy = initParkingLogBoss();

        Assert.assertEquals(parkingLotBoy.pickUp("3b1cd11db5714998b36ce2c5b19ff245").toString(), "车牌号：陕A-55555");

    }

    @Test(expected = BusinessException.class)
    public void have_error_ticket_should_return_null() throws BusinessException {
        ParkingLotBoy parkingLotBoy = initParkingLogBoss();
        parkingLotBoy.pickUp("3b1cd11db5714998b36ce2c5b19fas32fas");
    }

    private ParkingLotBoy initParkingLogBoss() {
        ParkingLotBoy parkingLotBoy = new ParkingLotBoy();
        List<ParkingLot> parkingLots = new ArrayList<>();
        List<String> places = new ArrayList(Arrays.asList("陕A-55555"));
        parkingLots.add(new ParkingLot(1, places));
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(new Ticket("3b1cd11db5714998b36ce2c5b19ff245", "陕A-55555"));
        ParkingService.setTickets(tickets);
        parkingLots.add(new ParkingLot(1));
        parkingLotBoy.setParkingLots(parkingLots);
        return parkingLotBoy;
    }


}
