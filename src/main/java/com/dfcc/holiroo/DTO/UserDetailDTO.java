package com.dfcc.holiroo.DTO;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserDetailDTO {

    private String userId;

    private String userName;

    private String userEmail;

    private String userBirthday;

    private String userGender;

    private String userPhone;

    private BigDecimal userCredit;
}
