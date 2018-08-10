package com.dfcc.holiroo.service.impl;

import com.dfcc.holiroo.DTO.UserDetailDTO;
import com.dfcc.holiroo.DTO.UserLogInDTO;
import com.dfcc.holiroo.converter.UserDetail2UserDetailDTOConverter;
import com.dfcc.holiroo.converter.UserForm2UserDetailConverter;
import com.dfcc.holiroo.dataObject.UserDetail;
import com.dfcc.holiroo.enums.ResultEnum;
import com.dfcc.holiroo.exception.HolirooException;
import com.dfcc.holiroo.form.UserUpdateForm;
import com.dfcc.holiroo.repository.UserDetailRepository;
import com.dfcc.holiroo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDetailRepository userDetailRepository;

    @Override
    @Transactional
    public UserLogInDTO signUp(UserDetail userDetail) {
        Optional<UserDetail> feedback = userDetailRepository.findByUserEmail(userDetail.getUserEmail());
        if(feedback.isPresent() == true){
            throw new HolirooException(ResultEnum.EMAIL_EXIST);
        }
        else {
            UserDetail temp = userDetailRepository.save(userDetail);

            UserLogInDTO userLogInDTO = new UserLogInDTO();
            userLogInDTO.setUserId(temp.getUserId());
            userLogInDTO.setUserName(temp.getUserName());
            userLogInDTO.setUserCredit(temp.getUserCredit());

            return userLogInDTO;
        }
    }

    @Override
    @Transactional
    public UserLogInDTO update(UserUpdateForm userUpdateForm) {

        Optional<UserDetail> userDetail = userDetailRepository.findById(userUpdateForm.getUserId());
        if(userDetail.isPresent() == false){
            throw new HolirooException((ResultEnum.USER_NOT_EXIST));
        }
        else{
            UserDetail newUserDetail = UserForm2UserDetailConverter.convert(userUpdateForm, userDetail.get());
            UserDetail temp = userDetailRepository.save(newUserDetail);

            UserLogInDTO userLogInDTO = new UserLogInDTO();
            userLogInDTO.setUserId(temp.getUserId());
            userLogInDTO.setUserName(temp.getUserName());
            userLogInDTO.setUserCredit(temp.getUserCredit());

            return userLogInDTO;
        }
    }

    @Override
    public UserDetailDTO search(String userId) {
        Optional<UserDetail> userDetail = userDetailRepository.findById(userId);
        if(userDetail.isPresent() == false){
            throw new HolirooException((ResultEnum.USER_NOT_EXIST));
        }
        else{
            return UserDetail2UserDetailDTOConverter.convert(userDetail.get());
        }
    }

    @Override
    public UserLogInDTO logIn(String userEmail, String userPassword) {
        Optional<UserDetail> userDetail = userDetailRepository.findByUserEmail(userEmail);
        if(userDetail.isPresent() == false){
            throw new HolirooException((ResultEnum.USER_NOT_EXIST));
        }
        if (!userDetail.get().getUserPassword().equals(userPassword)){
            throw new HolirooException(ResultEnum.WRONG_PASSWORD);
        }

        UserLogInDTO userLogInDTO = new UserLogInDTO();
        userLogInDTO.setUserId(userDetail.get().getUserId());
        userLogInDTO.setUserName(userDetail.get().getUserName());
        userLogInDTO.setUserCredit(userDetail.get().getUserCredit());

        return userLogInDTO;
    }
}
