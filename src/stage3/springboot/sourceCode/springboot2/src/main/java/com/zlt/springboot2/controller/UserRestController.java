package com.zlt.springboot2.controller;

import com.zlt.springboot2.entity.User;
import com.zlt.springboot2.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("测试注解的控制器")
public class UserRestController {
    @Autowired
    public UserService userService;

    @GetMapping("user")
    @ApiOperation(value = "根据用户ID查询用户",notes = "返回用户ID对应的对象")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "uid",value = "用户ID",required = true,dataType = "Long")
    })
    public User selectUserByUid(@RequestParam("uid") Long uid){
        return userService.selectUserByUid(uid);
    }
}
