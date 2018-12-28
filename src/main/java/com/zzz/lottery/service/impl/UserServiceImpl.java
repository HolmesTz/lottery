package com.zzz.lottery.service.impl;

import com.zzz.lottery.dao.UserMapper;
import com.zzz.lottery.entity.User;
import com.zzz.lottery.entity.param.UserRegisterParam;
import com.zzz.lottery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Transactional
    public int doRegister(UserRegisterParam param) {
        User user = new User();
        user.setUserId(UUID.randomUUID().toString());
        user.setPassword(param.getPassword());
        user.setUserName(param.getUserName());
        user.setPhonenumber(param.getPhonenumber());
        return userMapper.insert(user);
    }

}
