package com.example.RecomSys.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RegisterRequest {
    private String username;

    private String email;

    private String password;

    private String confirmPassword;

    private String role;
}
