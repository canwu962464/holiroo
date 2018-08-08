package com.dfcc.holiroo.VO;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserDetailVO {

    private String userName;

    private String userEmail;

    private String userBirthday;

    private String userGender;

    private String userPhone;
}
