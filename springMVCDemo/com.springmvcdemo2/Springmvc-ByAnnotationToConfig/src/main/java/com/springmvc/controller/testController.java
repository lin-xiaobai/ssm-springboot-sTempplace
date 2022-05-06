package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @date 2021/10/10 -16:53
 */
@Controller
public class testController {
    @RequestMapping("/")
    public String test(){
        return "index";
    }
//    拦截器页面
    @RequestMapping("/testIntercept")
    public String testIntercept(){
        return "success";
    }
//    自定义异常（如果在控制器执行的时候出现异常则会跳转到配置文件中指定的异常画面）
//    如果没有异常的话会跳转到成功的页面，如果执行的时候出现异常的话会跳转到 error页面
    @RequestMapping("/texteExption")
    public String texteExption(){
        System.out.println(1/0);
        return "success";
    }

//    测试js对象与json对象的关系
    @RequestMapping("/textjson")
    public String testjson(){
        return "json";
    }
//    ajax发请求
    @RequestMapping("/testajax")
    public String testajax(){
        return "ajax";
    }
//    处理ajax出来的请求

}
