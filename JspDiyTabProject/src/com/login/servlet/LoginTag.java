package com.login.servlet;

import javax.naming.Context;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.Writer;

/**
 * @date 2021/6/28 -15:09
 * 自定义标签：使用简单方式： 需要继承SimpleTag接口的实现类SimpleTagSupport
 */
public class LoginTag extends SimpleTagSupport {

//    在daTag()中完成逻辑

    @Override
    public void doTag() throws JspException, IOException {
//        判断 是否已经登录成功

//        获取JspContext对象（）
//        setJspContext()方法可以获取 jsp一些内置对象
//        setJspContext()的返回值是JspContext()对象，是JSP内置对象的入口对象的PageContext的父类
//        JspContext类中pageContext是jsp内置对象的入口
//
//        强转成 PageContext,可以通过 PageContext获取到jsp内置对象
        PageContext pageContext = (PageContext) getJspContext();

        HttpSession httpSession = pageContext.getSession();

        String uname = (String) httpSession.getAttribute("name");
//        如果成功，执行标签体
        if (uname != null) {
//            执行一次标签体
            getJspBody().invoke(null);
        }


//        如果失败，不执行


    }
}
