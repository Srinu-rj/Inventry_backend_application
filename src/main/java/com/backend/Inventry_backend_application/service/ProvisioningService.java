package com.backend.Inventry_backend_application.service;


import com.backend.Inventry_backend_application.model.Tenant;
import org.springframework.stereotype.Service;

@Service
public interface ProvisioningService {

    void provisionTenant(final Tenant tenant);
}
