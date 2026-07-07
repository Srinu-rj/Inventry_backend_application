package com.backend.Inventry_backend_application.email.repository;

import com.backend.Inventry_backend_application.email.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    boolean existsByEmail(String email);

    User findByEmailIgnoreCase(String email);

}
