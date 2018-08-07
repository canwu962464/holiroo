package com.dfcc.holiroo.service.impl;

import com.dfcc.holiroo.dataObject.UserDetail;
import com.dfcc.holiroo.enums.ResultEnum;
import com.dfcc.holiroo.exception.HolirooException;
import com.dfcc.holiroo.repository.UserDetailRepository;
import com.dfcc.holiroo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDetailRepository userDetailRepository;

    @Override
    public UserDetail signUp(UserDetail userDetail) {
        Optional<UserDetail> feedback = userDetailRepository.findByUserEmail(userDetail.getUserEmail());
        if(feedback.isPresent() == true){
            throw new HolirooException(ResultEnum.EMAIL_EXIST);
        }
        else {
            return userDetailRepository.save(userDetail);
        }
    }
}
