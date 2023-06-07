package com.targetindia.dao;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class DaoException extends RuntimeException {

    public DaoException(String message) {
        super(message);
    }

    public DaoException(Throwable cause) {
        super(cause);
    }

    public static DaoException fromList(List<String> errors) {
        String errorMessage = "";
        for (int i = 0; i < errors.size(); i++) {
            errorMessage += "%d. %s%n".formatted(i + 1, errors.get(i));
        }
        log.trace("Error message generated: {}", errorMessage );
        return new DaoException(errorMessage.trim());
    }
}
