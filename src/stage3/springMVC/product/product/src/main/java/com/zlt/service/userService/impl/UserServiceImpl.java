package com.zlt.service.userService.impl;

import com.zlt.entity.MyToken;
import com.zlt.entity.daoEntity.User;
import com.zlt.entity.daoEntity.UserExample;
import com.zlt.mapper.UserMapper;
import com.zlt.service.userService.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public void isLogin(String Token) {
        SecurityUtils.getSubject().login(new MyToken(Token));
    }

    @Override
    public User selectUserByUsername(String username) {
        UserExample example=new UserExample();
        example.createCriteria().andUsernameEqualTo(username);
        return userMapper.selectByExample(example).get(0);
    }
}
