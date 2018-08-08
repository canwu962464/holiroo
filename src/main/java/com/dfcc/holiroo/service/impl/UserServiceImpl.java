package com.dfcc.holiroo.service.impl;

import com.dfcc.holiroo.VO.UserDetailVO;
import com.dfcc.holiroo.converter.UserDetail2UserDetailVOConverter;
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
    public UserDetail signUp(UserDetail userDetail) {
        Optional<UserDetail> feedback = userDetailRepository.findByUserEmail(userDetail.getUserEmail());
        if(feedback.isPresent() == true){
            throw new HolirooException(ResultEnum.EMAIL_EXIST);
        }
        else {
            return userDetailRepository.save(userDetail);
        }
    }

    @Override
    @Transactional
    public UserDetail update(UserUpdateForm userUpdateForm) {

        Optional<UserDetail> userDetail = userDetailRepository.findById(userUpdateForm.getUserId());
        if(userDetail.isPresent() == false){
            throw new HolirooException((ResultEnum.USER_NOT_EXIST));
        }
        else{
            UserDetail newUserDetail = UserForm2UserDetailConverter.convert(userUpdateForm, userDetail.get());
            return userDetailRepository.save(newUserDetail);
        }
    }

    @Override
    public UserDetailVO search(String userId) {
        Optional<UserDetail> userDetail = userDetailRepository.findById(userId);
        if(userDetail.isPresent() == false){
            throw new HolirooException((ResultEnum.USER_NOT_EXIST));
        }
        else{
            return UserDetail2UserDetailVOConverter.convert(userDetail.get());
        }
    }
}
