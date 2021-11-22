package com.zlt.service.impl;

import com.zlt.entity.User;
import com.zlt.entity.UserExample;
import com.zlt.mapper.UserMapper;
import com.zlt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.REPEATABLE_READ,timeout = -1,rollbackFor = {})
    public User login(String username, String password) {
        UserExample userExample=new UserExample();
        userExample.createCriteria().andTbUsernameEqualTo(username).andPasswordEqualTo(password);
        List<User> users=userMapper.selectByExample(userExample);
        if (users!=null&&!users.isEmpty()){
            User user=new User();
            user.setUid(users.get(0).getUid());
            user.setRegtime(new Date());
            if (userMapper.updateByPrimaryKeySelective(user)>0) {
                return users.get(0);
            }
        }
        return null;
    }
}
