public class Ticket {
    private String id;
    private String plateNumber;

    public Ticket(String id, String plateNumber) {
        this.id = id;
        this.plateNumber = plateNumber;
    }

    public String getId() {
        return id;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    @Override
    public String toString() {
        return "------车票------\n" +
                "编号：" + id + "\n" +
                "车牌号：" + plateNumber + "\n";
    }
}
