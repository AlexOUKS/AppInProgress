package org.vinksel.ultimateprojectofdoom3000lesdeuxtours.exceptions;

public class WrongValueException extends RuntimeException{
	private Long resourceId;
	 
    public WrongValueException(Long resourceId, String message) {
        super(message);
        this.resourceId = resourceId;
    }
}
