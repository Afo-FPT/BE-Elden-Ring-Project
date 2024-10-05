package com.example.Elden.Ring.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCreateRequest {

    private String userId;

    @Size(min = 3, message = "USERNAME_INVALID")
    private String username;

    @Size(min = 8, message = "INVALID_PASSWORD" )
    private String password;

    @Email(message = "email is not valid")
    private String email;

    private String fullName;
    private String role;
    private String phone;
}
