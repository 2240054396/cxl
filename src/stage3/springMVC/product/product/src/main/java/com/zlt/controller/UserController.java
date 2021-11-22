package com.zlt.controller;

import com.zlt.controller.dto.Result;
import com.zlt.entity.daoEntity.User;
import com.zlt.service.userService.UserService;
import com.zlt.utils.JWTUtils;
import com.zlt.utils.MD5Util;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RedisTemplate redisTemplate;

    Logger logger=Logger.getLogger(UserController.class);

    @PostMapping("login")
    public Result<?> login(String username, String password, HttpServletRequest request, HttpServletResponse response){
        Result result=new Result();
        if (username.equals("cxl")&&password.equals("123")){
            result.setCode(0);
            result.setMsg("success");
        }else {
            result.setCode(1);
            result.setMsg("failed");
        }
        result.setData(null);
        User user=userService.selectUserByUsername(username);
        redisTemplate.opsForValue().set("username:"+user.getUsername(),user);
        String token = JWTUtils.sign(username, MD5Util.md5(password, user.getSalt(), 10));
        response.setHeader("Token",token);
        return result;
    }

    @RequestMapping("isLogin")
    public Result isLogin(HttpServletRequest request){
        String token = request.getHeader("Token");
        Result result=new Result();
        try {
            userService.isLogin(token);
            result.setCode(0);
        } catch (ArithmeticException e) {
            result.setCode(1);
            result.setMsg(e.getMessage());
        }
        return result;
    }

}
