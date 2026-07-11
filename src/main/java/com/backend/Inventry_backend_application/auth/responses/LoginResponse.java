package com.backend.Inventry_backend_application.auth.responses;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResponse {

    private String accessToken;
    private String tokenType;
}
