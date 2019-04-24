import entity.Car;
import entity.Ticket;
import org.junit.Assert;
import org.junit.Test;

public class ParkingLogTest {

    @Test
    public void have_one_parking_lot_should_return_one_parking_ticket() {
        ParkingLog parkingLog = new ParkingLog(3);
        Car car = new Car("陕A-66666");
        Ticket ticket = new Ticket(1, "陕A-66666");

        Assert.assertEquals(parkingLog.carParking(car).toString(), ticket.toString());
    }

    @Test
    public void no_have_parking_lot_should_return_null() {
        ParkingLog parkingLog = initPutOneCar();
        Car car1 = new Car("陕A-33333");

        Assert.assertEquals(parkingLog.carParking(car1), null);
    }

    @Test
    public void have_one_ticket_should_return_one_car() {
        ParkingLog parkingLog = initPutOneCar();
        Ticket ticket = new Ticket(1, "陕A-55555");

        Assert.assertEquals(parkingLog.pickUp(ticket).toString(), new Car("陕A-55555").toString());
    }

    @Test
    public void have_error_ticket_should_return_null() {
        ParkingLog parkingLog = initPutOneCar();
        Ticket ticket = new Ticket(0, "陕A-88888");

        Assert.assertEquals(parkingLog.pickUp(ticket), null);
    }

    private ParkingLog initPutOneCar(){
        ParkingLog parkingLog = new ParkingLog(1);
        Car car = new Car("陕A-55555");
        parkingLog.carParking(car);
        return parkingLog;
    }
}
