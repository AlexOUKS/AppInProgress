package org.vinksel.ultimateprojectofdoom3000lesdeuxtours.exceptions;

public class UnauthorizedAccessException  extends RuntimeException{
	private Long resourceId;
	 
    public UnauthorizedAccessException(Long resourceId, String message) {
        super(message);
        this.resourceId = resourceId;
    }
    public UnauthorizedAccessException(Long resourceId) {
        super("You aren't authorized to access at theses data");
        this.resourceId = resourceId;
    }
    public UnauthorizedAccessException() {
        super("You aren't authorized to access at theses data");
        this.resourceId = null;
    }
}
