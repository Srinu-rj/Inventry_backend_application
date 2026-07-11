package com.backend.Inventry_backend_application.service;

import com.backend.Inventry_backend_application.request.ProductRequest;
import com.backend.Inventry_backend_application.response.ProductResponse;
import org.springframework.stereotype.Service;

@Service
public interface ProductService extends BasicService<ProductRequest, ProductResponse> {

}
