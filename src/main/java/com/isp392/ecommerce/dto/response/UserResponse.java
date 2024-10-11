package com.isp392.ecommerce.dto.response;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class UserResponse {
    private String userId;
    private String username;



    private String email;

    private String fullName;
    private  Set<String> role;
//    private String phone;

}
