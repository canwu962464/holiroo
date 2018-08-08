package com.dfcc.holiroo.converter;

import com.dfcc.holiroo.VO.UserDetailVO;
import com.dfcc.holiroo.dataObject.UserDetail;

public class UserDetail2UserDetailVOConverter {
    public static UserDetailVO convert(UserDetail userDetail){

        UserDetailVO userDetailVO = new UserDetailVO();

        userDetailVO.setUserBirthday(userDetail.getUserBirthday());
        userDetailVO.setUserGender(userDetail.getUserGender());
        userDetailVO.setUserEmail(userDetail.getUserEmail());
        userDetailVO.setUserName(userDetail.getUserName());
        userDetailVO.setUserPhone(userDetail.getUserPhone());

        return userDetailVO;
    }
}