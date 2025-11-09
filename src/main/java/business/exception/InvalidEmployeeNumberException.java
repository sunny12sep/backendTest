package business.exception;

public class InvalidEmployeeNumberException extends RuntimeException {
	
	public InvalidEmployeeNumberException() {
		super("No employee exists with the given employee number");
	}
}