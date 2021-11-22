package com.zlt.springboot2.service.impl;

import com.zlt.springboot2.entity.User;
import com.zlt.springboot2.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Override
    @Cacheable(value = "zltredis",keyGenerator = "myKeyGenerator")
    public User selectUserByUid(Long uid) {
        log.info("执行了方法selectUserByUid值为{}",uid);
        return new User(uid,"cxl","123456","cool",new Date(),21);
    }
}
