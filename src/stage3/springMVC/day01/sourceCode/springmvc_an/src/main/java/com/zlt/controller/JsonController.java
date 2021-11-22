package com.zlt.controller;

import com.zlt.entity.FastJsonUser;
import com.zlt.entity.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("json")
public class JsonController {

    @RequestMapping("json")
    public User json(){
        return new User("qwe","asd",new Date());
    }

    @RequestMapping("json2")
    public User json2(@RequestBody User user){
        return user;
    }

    @RequestMapping("json3")
    public FastJsonUser json3(@RequestBody FastJsonUser fastJsonUser){
        return fastJsonUser;
    }
}
