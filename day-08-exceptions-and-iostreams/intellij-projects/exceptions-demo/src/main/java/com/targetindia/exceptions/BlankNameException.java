package com.targetindia.exceptions;

public class BlankNameException extends Exception{
    public BlankNameException() {
        super("Name cannot be blank");
    }

    public BlankNameException(String message) {
        super(message);
    }

    public BlankNameException(String message, Throwable cause) {
        super(message, cause);
    }

    public BlankNameException(Throwable cause) {
        super(cause);
    }

    public BlankNameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
