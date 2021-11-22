package com.zlt.service.impl;

import com.zlt.entity.User;
import com.zlt.entity.UserExample;
import com.zlt.mapper.UserMapper;
import com.zlt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public User login(String username, String password) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andTbUsernameEqualTo(username).andPasswordEqualTo(password);
        List<User> users = userMapper.selectByExample(userExample);
        return users != null && !users.isEmpty() ? users.get(0) : null;
    }
}
