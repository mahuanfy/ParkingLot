import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParkingLogBossTest {
    @Test
    public void one_parking_no_places_tow_parking_have_empty_parking_space_should_return_one_parking_ticket() {
        ParkingLogBoss parkingLogBoss = initParkingLogBoss();
        Car car = new Car("陕A-66666");

        Assert.assertEquals(parkingLogBoss.carParking(car).toString(), "------车票------\n" +
                "编号：1\n" +
                "车牌号：陕A-66666\n");
    }

    @Test
    public void have_one_ticket_should_return_one_car() {
        ParkingLogBoss parkingLogBoss = initParkingLogBoss();
        Ticket ticket = new Ticket(1, "陕A-55555");

        Assert.assertEquals(parkingLogBoss.pickUp(ticket).toString(), "车牌号：陕A-55555");

    }

    @Test
    public void have_error_ticket_should_return_null() {
        ParkingLogBoss parkingLogBoss = initParkingLogBoss();

        Assert.assertNull(parkingLogBoss.pickUp(new Ticket(2, "陕A-66666")));
    }

    private ParkingLogBoss initParkingLogBoss() {
        ParkingLogBoss parkingLogBoss = new ParkingLogBoss();
        List<ParkingLog> parkingLogs = new ArrayList<>();
        List<String> places = new ArrayList(Arrays.asList("陕A-55555"));
        parkingLogs.add(new ParkingLog(1, places));
        parkingLogs.add(new ParkingLog(1));
        parkingLogBoss.setParkingLogs(parkingLogs);
        return parkingLogBoss;
    }


}
