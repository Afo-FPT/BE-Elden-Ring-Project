package com.example.Elden.Ring.DTO.request;

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
