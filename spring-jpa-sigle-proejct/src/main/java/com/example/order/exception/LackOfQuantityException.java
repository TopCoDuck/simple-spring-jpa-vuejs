package com.example.order.exception;

public class LackOfQuantityException extends RuntimeException {
	
    public LackOfQuantityException(final String message) {
        super(message);
    }
    
}
