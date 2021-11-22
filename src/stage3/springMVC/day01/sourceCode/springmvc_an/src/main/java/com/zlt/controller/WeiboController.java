package com.zlt.controller;

import com.zlt.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Date;

@Controller
@RequestMapping(value = "weibo",method = RequestMethod.GET)
public class WeiboController {
    @RequestMapping("weibo")
    public String weibo(){
        return "weibo";
    }

    @RequestMapping("weibo2")
    @ResponseBody
    public User weibo2(){
        return new User("lisi","123",new Date());
    }
}
