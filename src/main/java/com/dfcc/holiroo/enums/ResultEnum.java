package com.dfcc.holiroo.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {

    USER_FORM_ERROR(00, "There is error is user detail form"),
    EMAIL_EXIST(01,"Email has existed, try to sign up with another email address."),
    ;


    private int code;
    private String message;

    ResultEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
