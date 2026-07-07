package com.backend.Inventry_backend_application.repository;

import com.backend.Inventry_backend_application.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

//    Optional<Product> findByReferenceIgnoreCase(String reference);
}
