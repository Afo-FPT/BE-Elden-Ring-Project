package com.isp392.ecommerce.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public enum ErrorCode {
    INVALIDKEY(4444, "invalid mesage key"),
    UNCATEGORIZED(666, "uncategiried exception"),
    USER_EXISTED(1001, "user existed"),
    USERNAME_INVALID(1003, "Usernane must be at least 3 characters!"),
    INVALID_PASSWORD(1004, "password must be 8 characters!"),
    EMAIL_EXISTED(1005, "email already exist, use another email!"),
    USER_NOTEXISTED(1006, "user not exist"),
    UNAUTHENTICATED(1007, "unauthenticated!")
    ;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

}
