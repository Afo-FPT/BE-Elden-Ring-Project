package com.example.Elden.Ring.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UserCreateRequest {
    private String userId;
    private String password;
    private String email;
}
