package com.backend.Inventry_backend_application.controller;

import com.backend.Inventry_backend_application.request.CategoryRequest;
import com.backend.Inventry_backend_application.service.CategoryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
public class CategoryController {

    final private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<?> saveCategory(@Valid @RequestBody final CategoryRequest request) {
        this.categoryService.create(request);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{category_id}")
    public ResponseEntity<?> updateCategory(@Valid @RequestBody final CategoryRequest request,@PathVariable("category_id") final String id) {
        this.categoryService.update(id, request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findByID(@PathVariable final String id) {
        this.categoryService.findById(id);
        return ResponseEntity.ok(this.categoryService.findById(id));
    }

    @DeleteMapping("/{category_id}")
    public ResponseEntity<?>deleteById(@PathVariable("category_id") final String id){
        this.categoryService.delete(id);
        return ResponseEntity.ok().build();
    }

}
