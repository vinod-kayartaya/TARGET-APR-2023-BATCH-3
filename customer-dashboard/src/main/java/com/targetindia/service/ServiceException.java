package com.targetindia.service;

import com.targetindia.dao.DaoException;

import java.util.List;

public class ServiceException extends RuntimeException{
    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public static ServiceException fromList(List<String> errors) {
        String errorMessage = "";
        for (int i = 0; i < errors.size(); i++) {
            errorMessage += "%d. %s%n".formatted(i + 1, errors.get(i));
        }
        return new ServiceException(errorMessage.trim());
    }
}
