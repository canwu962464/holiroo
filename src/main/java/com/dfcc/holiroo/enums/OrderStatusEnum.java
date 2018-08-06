package com.dfcc.holiroo.enums;

import lombok.Getter;

@Getter
public enum OrderStatusEnum {
    NEW(0,"booked but not confirmed"),
    WAIT_TO_BE_PAID(1,"confirmed but not paied"),
    PAID(2, "confirmed and paid"),
    COMPLETED(3, "completed but not remarked yet"),
    REMARKED(4, "remarked"),
    ;

    private Integer code;
    private String message;

    OrderStatusEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }
}
