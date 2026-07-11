package com.backend.Inventry_backend_application.service;


import com.backend.Inventry_backend_application.common.PageResponse;
import com.backend.Inventry_backend_application.request.UserRequest;
import com.backend.Inventry_backend_application.response.UserResponse;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends UserDetailsService {

    void createUser(final UserRequest request);

    void updateUser(final String userId, final UserRequest request);

    void deleteUser(final String userId);

    UserResponse getUserById(final String userId);

    PageResponse<UserResponse> getAllUsers(final int page, final int size);

    void enableUser(final String userId);

    void disableUser(final String userId);
}
