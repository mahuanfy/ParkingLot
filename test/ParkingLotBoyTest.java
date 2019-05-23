import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ParkingLotBoyTest {

    @InjectMocks
    ParkingLotBoy parkingLotBoy = new ParkingLotBoy();

    @Mock
    ParkingService parkingService;

    @Mock
    ParkingLot parkingLot;

    @Before
    public void start() throws BusinessException {
        parkingLotBoy.addParkingLot(parkingLot);

        when(parkingLot.getParkingSize()).thenReturn(5);
        List<String> spyList = spy(parkingLot.getPlaces());
        doReturn(3).when(spyList).size();
        when(parkingService.findTicketById("3b1cd11db5714998b36ce2c5b19ff245"))
                .thenReturn(new Ticket("3b1cd11db5714998b36ce2c5b19ff245", "车牌号：陕A-55555"));
    }

    @Test
    public void one_parking_no_places_tow_parking_have_empty_parking_space_should_return_one_parking_ticket() throws BusinessException {
        Car car = new Car("陕A-66666");
        parkingLotBoy.park(car);
        verify(parkingLot).park(any(Car.class));
    }

    @Test
    public void have_one_ticket_should_return_one_car() throws BusinessException {

        parkingLotBoy.pickUp("3b1cd11db5714998b36ce2c5b19ff245");
        verify(parkingLot).pickUp(any(Ticket.class));

    }
}
