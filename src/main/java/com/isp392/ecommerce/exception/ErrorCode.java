package com.isp392.ecommerce.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public enum ErrorCode {
    INVALID_KEY(4444, "invalid message key"),
    UNCATEGORIZED(666, "uncategorized exception"),
    USER_EXISTED(1001, "user existed"),
    USERNAME_INVALID(1003, "User name must be at least 3 characters!"),
    INVALID_PASSWORD(1004, "password must be 8 characters!"),
    EMAIL_EXISTED(1005, "email already exist, use another email!"),
    USER_NOT_EXISTED(1006, "user not exist"),
    UNAUTHENTICATED(1007, "unauthenticated!"),
    USERNAME_OR_PASSWORD_WRONG(1002 ,"Invalid username or password!"),
    TOKEN_INVALID(1008,"Invalid token!"),
    ;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

}
