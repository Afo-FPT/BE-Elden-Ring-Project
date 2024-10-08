package com.isp392.ecommerce.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode

public class UserUpdateRequest {
    private String password;
    private String email;
    private String fullName;
    private String phone;
}
