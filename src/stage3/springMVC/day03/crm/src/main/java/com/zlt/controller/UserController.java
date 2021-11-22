package com.zlt.controller;

import com.github.pagehelper.PageInfo;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.zlt.dto.Result;
import com.zlt.service.UserService;
import com.zlt.shiro.config.JWTToken;
import com.zlt.utils.StringUtils;
import com.zlt.vo.MenuVo;
import com.zlt.vo.UserVo;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("user")
public class UserController {
    Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private DefaultKaptcha kaptcha;

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    @GetMapping("validate")
    public String validate(HttpServletResponse response) {
        String text = kaptcha.createText();
        logger.debug("验证码为" + text);
        String uuid = StringUtils.uuid();
        redisTemplate.opsForValue().set(uuid, text, 3, TimeUnit.MINUTES);
        response.setHeader("ValidateKey", uuid);
        BufferedImage image = kaptcha.createImage(text);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "jpg", outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Base64.getEncoder().encodeToString(outputStream.toByteArray());
    }

    @GetMapping("isLogin")
    public Result<?> result() {
        return new Result<Object>(0, "已经登录", null);
    }


    @PostMapping("login")
    public Result<?> login(String username, String password, HttpServletResponse response, HttpServletRequest request, String captcha) {
        Result<?> result = new Result<Object>();
        if (StringUtils.isNotNull(captcha)) {
            String validateKey = request.getHeader("ValidateKey");
            String kapcha = redisTemplate.opsForValue().get(validateKey);
            if (kapcha == null) {
                result.setCode(1);
                result.setMsg("验证码过期");
                return result;
            }
            if (!kapcha.equalsIgnoreCase(captcha)) {
                result.setCode(1);
                result.setMsg("验证码错误");
                return result;
            }
        }
        try {
            String token = userService.login(username, password);
            response.setHeader("Token", token);
            result.setCode(0);
            result.setMsg("登录成功");
        } catch (AuthenticationException e) {
            logger.debug("登录失败" + e);
            result.setCode(1);
            result.setMsg(e.getMessage());
        }
        return result;
    }

    @RequestMapping("menu")
    public MenuVo menu(String Token) {
        try {
            SecurityUtils.getSubject().login(new JWTToken(Token));
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return null;
        }
        return userService.getMenu();
    }

    @GetMapping("userList")
    public Result<PageInfo<UserVo>> users(
            @RequestParam(value = "pageNow", required = false, defaultValue = "0") Integer pageNow,
            @RequestParam(value = "limit", required = false, defaultValue = "5") Integer limit,
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "nickname", required = false) String nickname
    ) {
        Result<PageInfo<UserVo>> result=new Result<>();
        result.setCode(0);
        PageInfo<UserVo> pageInfo=userService.select(pageNow,limit,username,nickname);
        result.setData(pageInfo);
        return result;
    }
}
