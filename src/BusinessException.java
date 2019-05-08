import java.util.function.Supplier;

public class BusinessException extends Exception {
    private String massage;

    public BusinessException(String massage) {
        this.massage = massage;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}
