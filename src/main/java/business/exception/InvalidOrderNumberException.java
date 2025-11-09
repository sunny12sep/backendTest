package business.exception;

public class InvalidOrderNumberException extends RuntimeException {
    public InvalidOrderNumberException() {
        super("No order exists with the given order number");
    }
}