package business.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BusinessAppGlobalExceptionHandler {
	
	@ExceptionHandler(value = InvalidEmployeeNumberException.class)
	public ResponseEntity<String> invalidEmployeeException(InvalidEmployeeNumberException ex){
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = InvalidCustomerNumberException.class)
	public ResponseEntity<String> invalidCustomerException(InvalidCustomerNumberException ex){
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = InvalidProductCodeException.class)
    public ResponseEntity<String> invalidProductException(InvalidProductCodeException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(value = InvalidOrderNumberException.class)
    public ResponseEntity<String> invalidOrderException(InvalidOrderNumberException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(value = InvalidStatusException.class)
	public ResponseEntity<String> invalidStatusException(InvalidStatusException ex){
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
}