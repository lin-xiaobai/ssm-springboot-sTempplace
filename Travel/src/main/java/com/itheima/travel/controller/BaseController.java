package com.itheima.travel.controller;

import com.itheima.travel.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 所有控制器的父类
 */
public class  BaseController {

    //注：这里的三个对象是由Spring生成并且注入进来的，不同的用户会话，请求和响应对象各不相同。
    @Autowired
    protected HttpSession session;

    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected HttpServletResponse response;

    /**
     * 从会话域中获取用户对象
     */
    protected User getUserFromSession() {
        return (User) session.getAttribute("user");
    }
}
