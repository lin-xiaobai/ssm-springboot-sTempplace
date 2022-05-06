package com.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @date 2021/10/9 -16:46
 * 拦截器类上的控制器
 */
@Controller
public class InterceptorController {
//    主页面
    @RequestMapping("/testIndex")
    public String testIndex(){
        return "index_Interceptor";
    }
//    自定义拦截器 需要自己创建一个拦截器类
    @RequestMapping("/testInterceptor")
    public String testInterceptor(){
        return "success";
    }
}
