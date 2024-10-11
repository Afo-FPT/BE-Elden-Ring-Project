package com.isp392.ecommerce.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public enum ErrorCode {
    INVALIDKEY(4444, "invalid message key"),
    UNCATEGORIZED(666, "uncategorized exception"),
    USER_EXISTED(1001, "user existed"),
    USERNAME_INVALID(1003, "Usernane must be at least 3 characters!"),
    INVALID_PASSWORD(1004, "password must be 8 characters!"),
    EMAIL_EXISTED(1005, "email already exist, use another email!"),
    USER_NOTEXISTED(1006, "user not exist"),
    UNAUTHENTICATED(1007, "unauthenticated!"),
    USERNAME_OR_PASSWORD_WRONG(1002 ,"Invalid username or password!"),
    WRONG_EMAIL_FORMAT(1008, "Email format is incorrect!"),
    FULLNAMEEMPTY(1009, "fullname must not be empty!"),
    PHONEEMPTY(1010,"phone number must not be empty"),
    ADDRESSEMPTY(1011, "address must not be empty!"),
    PHONEEXISTED(1012, "this phone number is already exist!"),
    PRODUCTNOTEXIST(1013,"product not exist"),
    BLANKINFO(1014,"information must not be blank")
    ;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

}
