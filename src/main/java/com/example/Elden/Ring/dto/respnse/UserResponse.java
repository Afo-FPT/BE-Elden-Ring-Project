package com.example.Elden.Ring.dto.respnse;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class UserResponse {
    private String userId;

    private String username;

    private String password;


    private String email;

    private String fullName;
    private String role;
    private String phone;
}
