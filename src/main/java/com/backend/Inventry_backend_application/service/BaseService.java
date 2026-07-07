package com.backend.Inventry_backend_application.service;

import org.springframework.stereotype.Service;

@Service
public interface BaseService<I,O> {

    void create (final I request);
    void update(final String id, final I request);
    O findById(final String id);
    void delete(final String id);
}
