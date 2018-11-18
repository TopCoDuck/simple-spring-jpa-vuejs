package com.example.order.exception;

public class NoHasItemException  extends RuntimeException {
    public NoHasItemException(final String message) {
        super(message);
    }
}
