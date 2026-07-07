package com.backend.Inventry_backend_application.config;

public class TenantCotext {
    private static final ThreadLocal<String> CURRENT_TENANT = new ThreadLocal<>();

    public static void setCurrentTenant(final String tenant) {
        CURRENT_TENANT.set(tenant);
    }

    public static String getCurrentTenant() {
        return CURRENT_TENANT.get();
    }

    public static void clean() {
        CURRENT_TENANT.remove();
    }
}
