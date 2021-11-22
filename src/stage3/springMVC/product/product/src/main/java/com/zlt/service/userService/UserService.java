package com.zlt.service.userService;


import com.zlt.entity.daoEntity.User;

public interface UserService {
    void isLogin(String Token);

    User selectUserByUsername(String username);
}
