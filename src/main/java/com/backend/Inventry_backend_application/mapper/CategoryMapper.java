package com.backend.Inventry_backend_application.mapper;

import com.backend.Inventry_backend_application.model.Category;
import com.backend.Inventry_backend_application.request.CategoryRequest;
import com.backend.Inventry_backend_application.response.CategoryResponse;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public Category toEntity(final CategoryRequest request) {
        return Category.builder()
                       .name(request.getName())
                       .description(request.getDescription())
                       .deleted(false)
                       .build();
    }

    public CategoryResponse toResponse(final Category entity) {
        final int nbProduct = 0; // TODO entity.getProducts() == null ? 0 : entity.getProducts().size();
        return CategoryResponse.builder()
                               .id(entity.getId())
                               .name(entity.getName())
                               .description(entity.getDescription())
                               .nbProducts(nbProduct)
                               .build();
    }
}
