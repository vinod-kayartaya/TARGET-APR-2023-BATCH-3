package com.targetindia.dao;

import java.util.List;

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
        return new DaoException(errorMessage.trim());
    }
}
