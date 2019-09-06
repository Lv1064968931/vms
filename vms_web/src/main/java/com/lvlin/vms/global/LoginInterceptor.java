package com.lvlin.vms.global;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        String url = httpServletRequest.getRequestURI();
        if(url.toLowerCase().indexOf("register")>=0||url.toLowerCase().indexOf("login")>=0||url.toLowerCase().indexOf("warning")>=0||url.toLowerCase().indexOf("client")>=0||url.toLowerCase().indexOf("rfid")>=0){
            return true;
        }
        HttpSession session = httpServletRequest.getSession();
        if(session.getAttribute("user")!=null){
            return true;
        }
        httpServletResponse.sendRedirect("/user/to_login");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
