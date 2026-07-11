package com.backend.Inventry_backend_application.repository;

import com.backend.Inventry_backend_application.model.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, String> {

    boolean existsByCompanyCode(String companyCode);
    boolean existsByEmail(String email);
}
