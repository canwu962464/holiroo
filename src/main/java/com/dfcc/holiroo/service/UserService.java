package com.dfcc.holiroo.service;

import com.dfcc.holiroo.DTO.UserDetailDTO;
import com.dfcc.holiroo.DTO.UserLogInDTO;
import com.dfcc.holiroo.dataObject.UserDetail;
import com.dfcc.holiroo.form.UserUpdateForm;

public interface UserService {

    //user sign up
    UserLogInDTO signUp(UserDetail userDetail);

    UserLogInDTO update(UserUpdateForm userUpdateForm);

    UserDetailDTO search(String userId);

    UserLogInDTO logIn(String userEmail, String userPassword);
}
