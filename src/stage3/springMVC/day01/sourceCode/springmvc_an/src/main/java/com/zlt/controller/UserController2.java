package com.zlt.controller;

import com.zlt.entity.User2;
import com.zlt.vo.Result;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("user2")
public class UserController2 {
    Logger logger=Logger.getLogger(UserController2.class);

    @GetMapping("{id}/{name}")
    public User2 selectUser(@PathVariable("id") Long uid, @PathVariable(value = "name",required = false) String name){
        logger.debug("select user by "+uid+" "+name);
        return new User2(1L,"cxl","123",new Date());
    }

    @GetMapping
    public List<User2> getUser(){
        logger.debug("getUser");
        List<User2> list=new ArrayList<User2>();
        list.add(new User2(1L,"cxl","123",new Date()));
        list.add(new User2(1L,"cxl","123",new Date()));
        list.add(new User2(1L,"cxl","123",new Date()));
        list.add(new User2(1L,"cxl","123",new Date()));
        return list;
    }

    @PostMapping
    public Result postUser(User2 user2){
        logger.debug("postUser");
        logger.debug(user2);
        return new Result(0,"post success",null);
    }

    @PutMapping
    public Result putUser(User2 user2){
        logger.debug("putUser");
        logger.debug(user2);
        return new Result(0,"put success",null);
    }
}
