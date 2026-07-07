package com.backend.Inventry_backend_application.serviceImpl;

import com.backend.Inventry_backend_application.mapper.CategoryMapper;
import com.backend.Inventry_backend_application.model.Category;
import com.backend.Inventry_backend_application.repository.CategoryRepository;
import com.backend.Inventry_backend_application.request.CategoryRequest;
import com.backend.Inventry_backend_application.response.CategoryResponse;
import com.backend.Inventry_backend_application.service.CategoryService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;

    @Override
    public void create(CategoryRequest request) {
        checkIfCategoryExitsByName(request.getName());
        final Category category = categoryMapper.toEntity(request);
        this.categoryRepository.save(category);
    }

    private void checkIfCategoryExitsByName(final String name) {
        final Optional<Category> category = categoryRepository.findByNameIgnoreCase(name);
        if (category.isPresent()) {
            log.debug("Category Already Exites");
            throw new RuntimeException("Category Already Exites");
        }
    }

    @Override
    public void update(final String id, final CategoryRequest request) {
        final Optional<Category> exitsCategory = this.categoryRepository.findById(id);
        if (exitsCategory.isPresent()) {
            log.debug("Category Already Exites");
            throw new RuntimeException("Category Already Exites");
        }
        final Category category = exitsCategory.get();
        //TODO CHECK IF CATEGORY IS EXITS
        if (category.getName().equalsIgnoreCase(request.getName())) {
            checkIfCategoryExitsByName(request.getName());
        }
        final Category updateCategory = categoryMapper.toEntity(request);
        updateCategory.setId(id);
        this.categoryRepository.save(updateCategory);
    }

    @Override
    public CategoryResponse findById(String id) {
        return this.categoryRepository.findById(id)
                .map(this.categoryMapper::toResponse)
                .orElseThrow(() -> new EntityNotFoundException("Category Not Found"));
    }

    @Override
    public void delete(String id) {
        final Category category = this.categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category Not Found"));
        this.categoryRepository.delete(category);

    }
}
