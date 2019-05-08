import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ParkingService {
    static List<Ticket> tickets = new ArrayList<>();

    public static void setTickets(List<Ticket> tickets) {
        ParkingService.tickets = tickets;
    }

    public Ticket createTicket(String plateNumber) {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        Ticket ticket = new Ticket(uuid, plateNumber);
        tickets.add(ticket);
        return ticket;
    }
    public Ticket findTicketById(String ticketId) throws BusinessException {
        return ParkingService.tickets.stream().filter(item -> item.getId().equals(ticketId)).findFirst().orElseThrow( () -> new BusinessException("没有找到车票.."));
    }
}
