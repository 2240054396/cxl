package com.zlt.controller.interceptor;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    Logger logger = Logger.getLogger(LoginInterceptor.class);

    public boolean preHandle(javax.servlet.http.HttpServletRequest request,
                             javax.servlet.http.HttpServletResponse response,
                             Object handler) throws Exception {
        logger.debug("preHandle");
        logger.debug(handler.getClass().getName());
        HandlerMethod handlerMethod= (HandlerMethod) handler;
        logger.debug(handlerMethod.getMethod());
        logger.debug(handlerMethod.getMethod().getName());
        return true;
    }

    public void postHandle(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.debug("postHandle");
        assert modelAndView != null;
        logger.debug(modelAndView.getViewName());
    }

    public void afterCompletion(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.debug("afterCompletion");
        logger.debug(ex);
    }
}
