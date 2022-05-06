package com.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @date 2021/10/12 -21:34
 */
@Controller
public class JsAndJson {
    //    测试js对象与json对象的关系
    @RequestMapping("/textjs")
    public String testjson(){
        return "json";
    }
    //    ajax发请求
    @RequestMapping("/testajax")
    public String testajax(){
        return "ajax";
    }
}
