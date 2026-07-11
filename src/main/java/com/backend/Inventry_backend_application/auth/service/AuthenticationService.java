package com.backend.Inventry_backend_application.auth.service;

import com.backend.Inventry_backend_application.auth.responses.LoginResponse;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {

    LoginResponse login(final LoginRequest request);
}
