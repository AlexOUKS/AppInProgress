package org.vinksel.ultimateprojectofdoom3000lesdeuxtours.validators;

import java.util.List;

public final class Validators {

    public static boolean isArrayEmpty(List array) {
        try {
        	if (array.isEmpty()) {
        		return true;
        	} else {
        		return false;
        	}
        } catch (NoSuchMethodError e){
        	return false;
        }
    }
    
    public static boolean isStringEmpty(String str) {
    	if (str == "" || str == null) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    public static boolean isNull(Object o) {
    	if (o == null) {
    		return true;
    	} else {
    		return false;
    	}
    }
}