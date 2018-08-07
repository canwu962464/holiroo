package com.dfcc.holiroo.exception;


import com.dfcc.holiroo.enums.ResultEnum;

public class HolirooException extends RuntimeException{

    private Integer code;

    public HolirooException(ResultEnum resultEnum){

        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public HolirooException(Integer code, String message) {

        super(message);

        this.code = code;
    }
}
