package com.targetindia.exceptions;

public class UnitPriceException extends RuntimeException{
    public UnitPriceException() {
        super("Invalid unit price given");
    }

    public UnitPriceException(String message) {
        super(message);
    }

    public UnitPriceException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnitPriceException(Throwable cause) {
        super(cause);
    }

    public UnitPriceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
