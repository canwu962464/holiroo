package com.dfcc.holiroo.controller;

import com.dfcc.holiroo.DTO.UserLogInDTO;
import com.dfcc.holiroo.VO.ResultVO;
import com.dfcc.holiroo.converter.ResultVO2ModelConverter;
import com.dfcc.holiroo.converter.UserForm2UserDetailConverter;
import com.dfcc.holiroo.dataObject.UserDetail;
import com.dfcc.holiroo.enums.ResultEnum;
import com.dfcc.holiroo.exception.HolirooException;
import com.dfcc.holiroo.form.UserDetailForm;
import com.dfcc.holiroo.form.UserUpdateForm;
import com.dfcc.holiroo.service.UserService;
import com.dfcc.holiroo.util.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ModelAndView signUp(@Valid UserDetailForm userDetailForm, BindingResult bindingResult
                             , Model model){
        if(bindingResult.hasErrors()){
            log.error("There is error in parameters, userDetailForm = {}", userDetailForm);
            throw new HolirooException(ResultEnum.USER_FORM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }

        UserDetail userDetail = UserForm2UserDetailConverter.convert(userDetailForm);

        Model newModel = ResultVO2ModelConverter.convert(model, ResultVOUtil.success(userService.signUp(userDetail)));

        return new ModelAndView("/index","model",newModel);
    }

    @PostMapping("/update")
    public String update(@Valid UserUpdateForm userUpdateForm, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            log.error("There is error in parameters, userDetailForm = {}", userUpdateForm.toString());
            throw new HolirooException(ResultEnum.USER_FORM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        else {
            UserLogInDTO userLogInDTO = userService.update(userUpdateForm);
            return "redirect://profile?userId=" + userLogInDTO.getUserId();
        }
    }

    @PostMapping("/profile")
    public ModelAndView search(@RequestParam("userId") String userId, Model model){

        Model newModel = ResultVO2ModelConverter.convert(model,  ResultVOUtil.success(userService.search(userId)));
        return new ModelAndView("/profile", "model", newModel);
    }

    @PostMapping("/login")
    public ModelAndView logIn(@RequestParam("userEmail") String userEmail,
                                        @RequestParam("userPassword") String userPassword, Model model){

        Model newModel = ResultVO2ModelConverter.convert(model, ResultVOUtil.success(userService.logIn(userEmail, userPassword)));
        return new ModelAndView("/index", "model", newModel);
    }

    //TODO: Not sure if it is corret to new a ModelAndView to log out the user info
    @GetMapping("/logout")
    public ModelAndView logOut(Model model) {
        model.addAttribute("userName", null);
        model.addAttribute("userId", null);
        model.addAttribute("userCredit", null);
        return new ModelAndView("/index"/*, "model", model*/);
    }
}
