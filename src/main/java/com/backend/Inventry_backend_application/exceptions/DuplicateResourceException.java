package com.backend.Inventry_backend_application.exceptions;

public class DuplicateResourceException extends BusinessException {

    public DuplicateResourceException(final String message) {
        super(message);
    }
}
