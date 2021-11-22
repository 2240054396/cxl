package com.zlt.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.zlt.entity.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping(name = "user", path = {"userController", "user"},
        method = {RequestMethod.GET, RequestMethod.POST})
public class UserController {

    Logger logger = Logger.getLogger(UserController.class);

    @RequestMapping(value = {"login"})
    public String login() {
        String s=null;
        assert false;
//        String upperCase = s.toUpperCase();
        return "login";
    }

    @RequestMapping(value = {"login2"})
    public String login2() {
        return "login2";
    }

    @RequestMapping("login3")
    public String login3() {
        return "forward:login";
    }

    @RequestMapping("login4")
    public String login4() {
        return "forward:/weibo/weibo";
    }

    @RequestMapping("login5")
    public String login5() {
        return "redirect:https://www.baidu.com";
    }

    @RequestMapping("login6")
    public String login6() {
        return "forward:https://www.baidu.com";
    }

    @RequestMapping("login7")
    public String login7() {
        return "redirect:login";
    }

    @RequestMapping("login8")
    public String login8() {
        return "redirect:/weibo/weibo";
    }

    @RequestMapping("login9")
    public ModelAndView login9() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(new User("cxl", "123"));
        modelAndView.setViewName("main2");
        return modelAndView;
    }

    @RequestMapping(value = "loginDo")
    public String loginDo(String username, String password, ModelMap modelMap) {
        logger.debug(username);
        logger.debug(password);
        modelMap.addAttribute("username", username);
        modelMap.addAttribute("password", password);
        return "main";
    }

    @RequestMapping(value = "loginDo2")
    public String loginDo2(User user, ModelMap modelMap) {
        logger.debug(user);
        modelMap.addAttribute("user", user);
        return "main2";
    }

    @RequestMapping("loginDo3")
    public String loginDo3(User user, ModelMap modelMap) {
        logger.debug(user);
        modelMap.addAttribute(user);
        return "main2";
    }

    @RequestMapping("login10")
    public String login10() {
        return "login3";
    }

    @RequestMapping("login11")
    public String login11() {
        return "login4";
    }

    @RequestMapping("loginDo4")
    public String loginDo4(User user, ModelMap modelMap) {
        logger.debug(user);
        modelMap.addAttribute(user);
        return "main2";
    }

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public String upload(@RequestParam("name") String name, @RequestParam(name = "photo", required = true) CommonsMultipartFile files[]) {
        String path = "D:\\study\\javaProject\\cxl\\src\\stage3\\springMVC\\day01\\" +
                "sourceCode\\springmvc_an\\src\\main\\webapp\\uploadFiles";
        logger.debug(name);

        for (CommonsMultipartFile file : files) {
            String originalFilename = file.getOriginalFilename();
            path += "/" + UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
            try {
                file.transferTo(new File(path));
                return "main2";
            } catch (IOException e) {
                e.printStackTrace();
                return "login";
            }
        }
        return "login";
    }
    @RequestMapping("login12")
    public String login12() {
        return "login5";
    }

    @RequestMapping("login13")
    public String login13() {
        return "login6";
    }

    @RequestMapping(value = "upload2", method = RequestMethod.POST)
    public String upload2(@RequestParam("name") String name, @RequestParam(name = "photo", required = true) CommonsMultipartFile files[]) {
        logger.debug(name);
        for (CommonsMultipartFile file : files) {
            String originalFilename = file.getOriginalFilename();
            originalFilename = "http://localhost:8088/upload/files/"+ UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
            Client client=Client.create();
            WebResource webResource = client.resource(originalFilename);
            webResource.put(file.getBytes());
        }
        return "main2";
    }

    @RequestMapping("testjson")
    @ResponseBody
    public User testJson(){
        return new User("cxl","123",new Date());
    }

    @RequestMapping("notFound")
    public String notFound(){
        return "notFound";
    }

}
