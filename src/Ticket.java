public class Ticket {
    private int id;
    private String licensePlate;

    public Ticket(int id, String licensePlate) {
        this.id = id;
        this.licensePlate = licensePlate;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    @Override
    public String toString() {
        return "------车票------\n" +
                "编号：" + id + "\n" +
                "车牌号：" + licensePlate + "\n";
    }
}
