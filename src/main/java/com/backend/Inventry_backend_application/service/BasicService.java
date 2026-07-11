package com.backend.Inventry_backend_application.service;

import com.backend.Inventry_backend_application.common.PageResponse;
import org.springframework.stereotype.Service;

@Service
public interface BasicService<I, O> {

    void create(final I request);

    void update(final String id, final I request);

    PageResponse<O> findAll(final int page, final int size);

    O findById(final String id);

    void delete(final String id);
}
