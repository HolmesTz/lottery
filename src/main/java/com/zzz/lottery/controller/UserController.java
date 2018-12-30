package com.zzz.lottery.controller;

import com.zzz.lottery.entity.User;
import com.zzz.lottery.entity.enumEntity.ResponseCodeEnum;
import com.zzz.lottery.entity.param.UserLoginParam;
import com.zzz.lottery.entity.param.UserRegisterParam;
import com.zzz.lottery.entity.responseEntity.ResponseEntity;
import com.zzz.lottery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "/login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(){
        return "/register";
    }

    @RequestMapping(value = "/gotoLogin", method = RequestMethod.GET)
    public String gotoLogin(){
        return "redirect:/user/login";
    }

    @RequestMapping(value = "/gotoRegister", method = RequestMethod.GET)
    public String gotoRegister(){
        return "redirect:/user/register";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity doLogin(UserLoginParam param, HttpServletRequest request){
        User user = userService.doLogin(param);
        if (user == null) {
            return new ResponseEntity(ResponseCodeEnum.FAILED.getCode(), ResponseCodeEnum.FAILED.getMessage(), null);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            return new ResponseEntity(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getMessage(), null);
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity doRegister(UserRegisterParam param){
        System.out.println(param.getPassword() + " " + param.getPhonenumber() + " " + param.getUserName());
        int result = userService.doRegister(param);
        if (result > 0) {
            return new ResponseEntity(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getMessage(), null);
        } else {
            return new ResponseEntity(ResponseCodeEnum.FAILED.getCode(), ResponseCodeEnum.FAILED.getMessage(), null);
        }
    }

}
