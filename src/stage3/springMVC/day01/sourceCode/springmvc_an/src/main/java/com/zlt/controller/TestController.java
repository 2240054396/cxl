package com.zlt.controller;

import com.zlt.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
public class TestController {
    @RequestMapping("test")
    public void test() {
        String s=null;
        assert false;
        String upperCase = s.toUpperCase();
    }

    @RequestMapping("test2")
    public ModelMap test2() {
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("username", "cxl");
        modelMap.addAttribute("password", "123");
        return modelMap;
    }

    @RequestMapping("test3")
    public List<User> test3() {
        List<User> list=new ArrayList<User>();
        list.add(new User("cxl","123"));
        return list;
    }

    @RequestMapping("test4")
    public Set<User> test4() {
        Set<User> set=new HashSet<User>();
        set.add(new User("cxl","123"));
        return set;
    }

    @RequestMapping("test5")
    public Map<String,String> test5() {
        Map<String,String> map=new HashMap<String, String>();
        map.put("username","cxl");
        map.put("password","123");
        return map;
    }

    @RequestMapping("test/test")
    public User test6() {
        return new User("cxl","123");
    }

}
