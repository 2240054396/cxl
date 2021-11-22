package com.zlt.controller;

import com.zlt.entity.User;
import com.zlt.service.UserService;
import com.zlt.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("login")
    public Result<User> login(String username, String password) {
        User login = userService.login(username, password);
        Result<User> result=new Result<User>();
        return login==null?new Result<User>(1,"login field",login):new Result<User>(0,"success",login);
    }
}
