package errors;

//checked exception
public class CarNotFoundException extends Exception {
    public CarNotFoundException() {
        super("Car not found");
    }
    public CarNotFoundException(Exception e) {
        super("Car not found", e);
    }

    public CarNotFoundException(String msg) {
        super(msg);
    }

    public CarNotFoundException(String msg, Exception e) {
        super(msg,e);
    }
}
