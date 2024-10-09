package com.isp392.ecommerce.dto.request;

import com.isp392.ecommerce.entity.Cart;
import com.isp392.ecommerce.exception.ErrorCode;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCreationRequest {

    private String userId;
    @Size(min = 3, message = "USERNAME_INVALID")
    private String username;
    @Size(min = 8, message = "INVALID_PASSWORD" )
    private String password;
    @Email(message = "WRONG_EMAIL_FORMAT")
    private String email;
    private String fullName;
    private Set<String> role;
    private String phone;


}
