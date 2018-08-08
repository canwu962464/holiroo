package com.dfcc.holiroo.service;

import com.dfcc.holiroo.VO.UserDetailVO;
import com.dfcc.holiroo.dataObject.UserDetail;
import com.dfcc.holiroo.form.UserDetailForm;
import com.dfcc.holiroo.form.UserUpdateForm;

public interface UserService {

    //user sign up
    UserDetail signUp(UserDetail userDetail);

    UserDetail update(UserUpdateForm userUpdateForm);

    UserDetailVO search(String userId);
}
