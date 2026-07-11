package com.backend.Inventry_backend_application.service;


import com.backend.Inventry_backend_application.common.PageResponse;
import com.backend.Inventry_backend_application.request.StockMvtRequest;
import com.backend.Inventry_backend_application.response.StockMvtResponse;
import org.springframework.stereotype.Service;

@Service
public interface StockMvtService extends BasicService<StockMvtRequest, StockMvtResponse> {

    PageResponse<StockMvtResponse> findAllByProductId(final String productId, final int page, final int size);
}
