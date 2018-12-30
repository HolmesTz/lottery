package com.zzz.lottery.service;

import com.zzz.lottery.entity.User;
import com.zzz.lottery.entity.param.UserLoginParam;
import com.zzz.lottery.entity.param.UserRegisterParam;

public interface UserService {

    int doRegister(UserRegisterParam param);

    User doLogin(UserLoginParam param);

}
