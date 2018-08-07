package com.dfcc.holiroo.controller;


import com.dfcc.holiroo.converter.UserDetailForm2UserDetailConverter;
import com.dfcc.holiroo.dataObject.UserDetail;
import com.dfcc.holiroo.enums.ResultEnum;
import com.dfcc.holiroo.exception.HolirooException;
import com.dfcc.holiroo.form.UserDetailForm;
import com.dfcc.holiroo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.math.BigDecimal;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/signup")
    public UserDetail signUp(@Valid UserDetailForm userDetailForm, BindingResult bindingResult
//                             @RequestParam("userName") String userName,
//                             @RequestParam("userPassword") String userPassword,
//                             @RequestParam("userEmail") String userEmail,
//                             @RequestParam("userBirthday") String userBirthday,
//                             @RequestParam("userGender") String userGender,
//                             @RequestParam("userPhone") String userPhone,
//                             @RequestParam("userAdmin") int userAdmin
                             //,@RequestParam(value = "userCredit", defaultValue = "0") BigDecimal userCredit
                             ){

//        UserDetail userDetail = new UserDetail();
//
//        userDetail.setUserName(userName);
//        userDetail.setUserPassword(userPassword);
//        userDetail.setUserEmail(userEmail);
//        userDetail.setUserBirthday(userBirthday);
//        userDetail.setUserGender(userGender);
//        userDetail.setUserPhone(userPhone);
//        userDetail.setUserAdmin(userAdmin);
//        userDetail.setUserCredit(userCredit);
        if(bindingResult.hasErrors()){
            log.error("There is error in parameters, userDetailForm = {}", userDetailForm);
            throw new HolirooException(ResultEnum.USER_FORM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }

        UserDetail userDetail = UserDetailForm2UserDetailConverter.convert(userDetailForm);

        return userService.signUp(userDetail);
    }

}
