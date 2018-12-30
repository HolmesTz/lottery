package com.zzz.lottery.service.impl;

import com.zzz.lottery.dao.UserMapper;
import com.zzz.lottery.entity.User;
import com.zzz.lottery.entity.param.UserLoginParam;
import com.zzz.lottery.entity.param.UserRegisterParam;
import com.zzz.lottery.service.UserService;
import com.zzz.lottery.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Transactional
    public int doRegister(UserRegisterParam param) {
        User user = new User();
        user.setUserId(UUID.randomUUID().toString());
        user.setPassword(MD5Util.getStrMD5(param.getPassword()));
        user.setUserName(param.getUserName());
        user.setPhonenumber(param.getPhonenumber());
        return userMapper.insert(user);
    }

    @Transactional
    public User doLogin(UserLoginParam param) {
        List<User> user = userMapper.selectUser(param.getPhonenumber());
        if (!CollectionUtils.isEmpty(user)) {
            if (user.get(0).getPassword().equals(MD5Util.getStrMD5(param.getPassword()))) {
                return user.get(0);
            }
        }
        return null;
    }

}
