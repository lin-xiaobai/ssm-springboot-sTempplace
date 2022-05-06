package com.springMVC.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @date 2021/10/10 -15:15
 * 基于注解的自定义异常信息处理
 */
//@ControllerAdvice将当前类标识为异常处理的组件
@ControllerAdvice //里面包含了@Controller 本质也是一个控制类
public class ExceptionControllerByannotation {

//    value写的是可能出现的异常类 类与类之间使用“，”隔开
//    如果控制器中出现value中写的异常，则会通过@ControllerAdvice标识的注解来作为当前控制器方法来执行
    @ExceptionHandler(value = {ArithmeticException.class,NullPointerException.class})
//    形参位置 Exception表示当前出现的异常
//    Model 可以通过Model在请求域中共享异常信息
    public String testExceptionByannotation(Exception ex, Model model){
        model.addAttribute("ex",ex);
        return "error";
    }

}
