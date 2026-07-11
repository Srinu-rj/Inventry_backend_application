package com.backend.Inventry_backend_application.service;


import com.backend.Inventry_backend_application.common.PageResponse;
import com.backend.Inventry_backend_application.request.RegisterTenantRequest;
import com.backend.Inventry_backend_application.response.TenantResponse;
import org.springframework.stereotype.Service;

@Service
public interface TenantService {

    void registerTenant(final RegisterTenantRequest request);

    void approveTenant(final String tenantId);

    void activateTenant(final String tenantId);

    void deactivateTenant(final String tenantId);

    void suspendTenant(final String tenantId);

    PageResponse<TenantResponse> findAll(final int page, final int size);
}
