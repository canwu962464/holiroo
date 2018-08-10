package com.dfcc.holiroo.converter;

import com.dfcc.holiroo.DTO.UserDetailDTO;
import com.dfcc.holiroo.dataObject.UserDetail;

public class UserDetail2UserDetailDTOConverter {
    public static UserDetailDTO convert(UserDetail userDetail){

        UserDetailDTO userDetailDTO = new UserDetailDTO();

        userDetailDTO.setUserId(userDetail.getUserId());
        userDetailDTO.setUserBirthday(userDetail.getUserBirthday());
        userDetailDTO.setUserGender(userDetail.getUserGender());
        userDetailDTO.setUserEmail(userDetail.getUserEmail());
        userDetailDTO.setUserName(userDetail.getUserName());
        userDetailDTO.setUserPhone(userDetail.getUserPhone());
        userDetailDTO.setUserCredit(userDetail.getUserCredit());

        return userDetailDTO;
    }
}