package com.zlt.springboot2.service;

import com.zlt.springboot2.entity.User;


public interface UserService {
    User selectUserByUid(Long uid);
}
