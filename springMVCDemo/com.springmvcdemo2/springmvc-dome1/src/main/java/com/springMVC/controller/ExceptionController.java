package com.springMVC.controller;

import com.springMVC.Bean.Userbean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @date 2021/10/10 -14:45
 * 基于在springmvc的核心配置文件sprngmvc.xml文件中配置自定义异常信息处理器
 * （控制器中出现异常后会跳到新的视图页面）
 */
@Controller
public class ExceptionController {
//    异常页面
    @RequestMapping("/indexException")
    public  String indexException(){
        return "index-ExceptionHandler";
    }

//    基于配置的自定义异常信息处理控制器
//    如果没有异常则会跳转到success页面，如果出现异常，则会跳转自定义的页面error页面
    @RequestMapping("/testExceptionHandler")
    public String testExceptionHandler(){
//        模拟控制器出现数字异常
            System.out.println(1/0);
//        出现了数字异常，然后会被自定义异常信息处理器捕获，并且会跳转到自定义异常页面
        return "success";
    }
}

