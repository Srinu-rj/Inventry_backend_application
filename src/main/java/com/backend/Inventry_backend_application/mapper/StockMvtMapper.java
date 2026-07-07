package com.backend.Inventry_backend_application.mapper;


import com.backend.Inventry_backend_application.model.Product;
import com.backend.Inventry_backend_application.model.StockMvt;
import com.backend.Inventry_backend_application.request.StockMvtRequest;
import com.backend.Inventry_backend_application.response.StockMvtResponse;
import org.springframework.stereotype.Component;

@Component
public class StockMvtMapper {

    public StockMvt toEntity(final StockMvtRequest request) {
        return StockMvt.builder()
                       .dateMvt(request.getDateMvt())
                       .comment(request.getComment())
                       .typeMvt(request.getTypeMvt())
                       .quantity(request.getQuantity())
                       .product(Product.builder()
                                       .id(request.getProductId())
                                       .build())
                .deleted(false)
                       .build();
    }

    public StockMvtResponse toResponse(final StockMvt entity) {
        return StockMvtResponse.builder()
                .id(entity.getId())
                               .dateMvt(entity.getDateMvt())
                               .comment(entity.getComment())
                               .typeMvt(entity.getTypeMvt())
                               .quantity(entity.getQuantity())
                               .build();
    }
}
