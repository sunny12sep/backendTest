package business.exception;

public class InvalidProductCodeException extends RuntimeException {
    public InvalidProductCodeException() {
        super("No product exists with the given product code");
    }
}