package com.zzz.lottery.dao;

import com.zzz.lottery.entity.User;
import com.zzz.lottery.entity.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    int insert(User record);

}