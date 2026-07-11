package com.backend.Inventry_backend_application.exceptions;

public class InvalidRequestException extends BusinessException {
    public InvalidRequestException(final String message) {
        super(message);
    }
}
