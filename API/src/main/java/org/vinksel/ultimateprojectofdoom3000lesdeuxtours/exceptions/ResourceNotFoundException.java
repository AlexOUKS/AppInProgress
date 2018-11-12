package org.vinksel.ultimateprojectofdoom3000lesdeuxtours.exceptions;

public class ResourceNotFoundException extends RuntimeException{
	private Long resourceId;
	 
    public ResourceNotFoundException(Long resourceId, String message) {
        super(message);
        this.resourceId = resourceId;
    }
}
