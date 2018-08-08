package com.dfcc.holiroo.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {

    USER_FORM_ERROR(00, "There is error is user detail form"),
    EMAIL_EXIST(01,"Email has existed, try to sign up with another email address."),
    USER_NOT_EXIST(02, "The user does not exist"),
    ;


    private int code;
    private String message;

    ResultEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
