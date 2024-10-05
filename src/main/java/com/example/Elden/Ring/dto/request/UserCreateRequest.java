package com.example.Elden.Ring.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UserCreateRequest {
    private String userId;

    @Size(min = 3, message = "username must be at least 3 character")
    private String username;

    @Size(min = 8, message = "password must be at least 8 character" )
    private String password;

    @Email(message = "email is not valid")
    private String email;
}
