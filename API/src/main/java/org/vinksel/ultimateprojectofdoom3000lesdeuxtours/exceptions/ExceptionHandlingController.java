package org.vinksel.ultimateprojectofdoom3000lesdeuxtours.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ExceptionHandlingController {
	@ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> resourceNotFound(ResourceNotFoundException ex) {
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode("Not Found");
        response.setErrorMessage(ex.getMessage());
 
        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
    }
	@ExceptionHandler(WrongValueException.class)
    public ResponseEntity<ExceptionResponse> wrongValueException(WrongValueException ex) {
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode("Wrong value");
        response.setErrorMessage(ex.getMessage());
 
        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
    }
	@ExceptionHandler(UnauthorizedAccessException.class)
    public ResponseEntity<ExceptionResponse> unauthorizedAccessException(UnauthorizedAccessException ex) {
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode("Unauthorized access");
        response.setErrorMessage(ex.getMessage());
 
        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.UNAUTHORIZED );
    }
	@ExceptionHandler(ExistingResourceException.class)
    public ResponseEntity<ExceptionResponse> existingResourceException(ExistingResourceException ex) {
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode("Existing resource");
        response.setErrorMessage(ex.getMessage());
 
        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.CONFLICT );
    }
}
