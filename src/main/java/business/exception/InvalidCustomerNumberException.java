package business.exception;

public class InvalidCustomerNumberException extends RuntimeException {
	public InvalidCustomerNumberException() {
		super("No customer exists with the given customer number");
	}
}