package com.zlt;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginDoController implements Controller {
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("main");
        modelAndView.addObject("username",username);
        modelAndView.addObject("password",password);
        return modelAndView;
    }
}
