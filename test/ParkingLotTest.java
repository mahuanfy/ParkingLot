import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ParkingLotTest {
    @InjectMocks
    ParkingLot parkingLot = initParkingLog();

    @Mock
    ParkingService parkingService;

    @Before
    public void start(){
        when(parkingService.createTicket(anyString()))
                .thenReturn(new Ticket("3b1cd11db5714998b36ce2c5b19ff245", "陕A-66666"));
    }

    @Test
    public void have_empty_parking_space_should_return_one_parking_ticket() throws BusinessException {

        Car car = new Car("陕A-66666");

        Assert.assertEquals(parkingLot.park(car).toString(), "------车票------\n" +
                "编号：3b1cd11db5714998b36ce2c5b19ff245\n" +
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
        Ticket ticket = new Ticket("3b1cd11db5714998b36ce2c5b19ff245", "陕A-55555");

        Assert.assertEquals(parkingLot.pickUp(ticket).toString(), "车牌号：陕A-55555");
    }

    @Test(expected = BusinessException.class)
    public void have_error_ticket_should_return_null() throws BusinessException {
        ParkingLot parkingLot = initPutOneCar();
        Ticket ticket = new Ticket("3b1cd11db5714998b36ce2c5b19ff245", "陕A-88888");
        parkingLot.pickUp(ticket);
    }

    private ParkingLot initPutOneCar() {
        return new ParkingLot(1, new ArrayList(Arrays.asList("陕A-55555")));
    }

    private ParkingLot initParkingLog() {
        return new ParkingLot(3);
    }
}
