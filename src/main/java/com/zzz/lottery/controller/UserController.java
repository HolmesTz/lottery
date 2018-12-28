package com.zzz.lottery.controller;

import com.zzz.lottery.entity.enumEntity.ResponseCodeEnum;
import com.zzz.lottery.entity.param.UserRegisterParam;
import com.zzz.lottery.entity.responseEntity.ResponseEntity;
import com.zzz.lottery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "index";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(){
        return "/register";
    }

    @RequestMapping(value = "/gotoRegister", method = RequestMethod.GET)
    public String gotoRegister(){
        return "redirect:/register";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity doLogin(){
        return null;
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity doRegister(@RequestBody UserRegisterParam param){
        int result = userService.doRegister(param);
        if (result > 0) {
            return new ResponseEntity(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getMessage(), null);
        } else {
            return new ResponseEntity(ResponseCodeEnum.FAILED.getCode(), ResponseCodeEnum.FAILED.getMessage(), null);
        }
    }

}
