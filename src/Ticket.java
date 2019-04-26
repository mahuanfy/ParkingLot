public class Ticket {
    private int id;
    private String plateNumber;

    public Ticket(int id, String plateNumber) {
        this.id = id;
        this.plateNumber = plateNumber;
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
