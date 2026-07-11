package com.backend.Inventry_backend_application.service;

import com.backend.Inventry_backend_application.request.CategoryRequest;
import com.backend.Inventry_backend_application.response.CategoryResponse;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService extends BasicService<CategoryRequest, CategoryResponse> {


}
