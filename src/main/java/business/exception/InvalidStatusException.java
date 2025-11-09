package business.exception;

public class InvalidStatusException extends RuntimeException {
	public InvalidStatusException() {
		super("Valid Status are Shipped, Resolved, Cancelled, On Hold, Disputed, In Process");
	}
}