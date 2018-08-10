package com.dfcc.holiroo.DTO;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserLogInDTO {

    private String userId;

    private String userName;

    private BigDecimal userCredit;
}
