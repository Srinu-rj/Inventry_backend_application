package com.backend.Inventry_backend_application.repository;


import com.backend.Inventry_backend_application.model.StockMvt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockMvtRepository extends JpaRepository<StockMvt, String> {
//    Page<StockMvt> findAllByProductId(String productId, Pageable pageable);
}
