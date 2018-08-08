package com.dfcc.holiroo.form;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
public class UserDetailForm {

    @NotEmpty(message = "Username is necessary.")
    private String userName;

    @NotEmpty(message = "Password is necessary.")
    private String userPassword;

    @NotEmpty(message = "Email address is necessary.")
    @Email(message = "Email form is no good.")
    private String userEmail;

    @NotEmpty(message = "Birthday is necessary.")
    private String userBirthday;

    @NotEmpty(message = "Gender is necessary")
    private String userGender;

    @NotEmpty(message = "Phone number is necessary.")
    private String userPhone;
}
