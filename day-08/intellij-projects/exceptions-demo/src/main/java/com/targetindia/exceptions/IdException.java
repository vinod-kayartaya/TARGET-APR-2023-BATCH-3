package com.targetindia.exceptions;

public class IdException extends RuntimeException{
    public IdException() {
        super("Invalid id supplied");
    }

    public IdException(String message) {
        super(message);
    }

    public IdException(Throwable cause) {
        super(cause);
    }
}

