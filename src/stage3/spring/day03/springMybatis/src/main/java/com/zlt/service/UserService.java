package com.zlt.service;

import com.zlt.entity.User;

public interface UserService {
    User login(String username, String password);
}
