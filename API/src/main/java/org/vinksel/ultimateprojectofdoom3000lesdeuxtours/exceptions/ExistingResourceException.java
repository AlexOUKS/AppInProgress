package org.vinksel.ultimateprojectofdoom3000lesdeuxtours.exceptions;

public class ExistingResourceException  extends RuntimeException{
	private Long resourceId;
	 
    public ExistingResourceException(String message) {
        super(message);
        this.resourceId = (long) 0;
    }
}
