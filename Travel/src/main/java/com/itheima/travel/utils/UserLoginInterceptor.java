package com.itheima.travel.utils;

import com.itheima.travel.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 用户权限拦截器
 */
@Slf4j
public class UserLoginInterceptor implements HandlerInterceptor {

    /**
     * 判断会话域中是否有用户的信息
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //得到会话域
        HttpSession session = request.getSession();
        //从会话域中获取用户对象
        User user = (User) session.getAttribute("user");
        //判断是否为空
        if (user == null) {
            log.info("拦截到非法请求，IP地址：" + request.getRemoteAddr());
            //重定向到登录页面
            response.sendRedirect(request.getContextPath() + "/login.html");
            //不再继续
            return false;
        }
        //放行
        return true;
    }
}
