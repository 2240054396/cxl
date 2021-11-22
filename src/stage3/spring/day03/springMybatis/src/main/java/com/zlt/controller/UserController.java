package com.zlt.controller;

import com.zlt.entity.User;
import com.zlt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    public User login(String username,String password){
        return userService.login(username,password);
    }
}
