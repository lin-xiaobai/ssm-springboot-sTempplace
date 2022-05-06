package com.springMVC.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @date 2021/10/13 -10:00
 */
@Controller
public class jsAndAjaxAndJsonController {

//    首页
    @RequestMapping("/indexjs")
    public String js(){
        return "js";
    }
//    登录页面
    @RequestMapping("/login")
    public String login(){
        return "login";
}
//处理ajax事件
    @RequestMapping("/check")
    @ResponseBody
    public String check(@RequestParam("user") String name,@RequestParam("age") Integer age) throws JsonProcessingException {
//        利用jackson框架解析或者转为json对象
        ObjectMapper objectMapper=new ObjectMapper();
        System.out.println(name+age);
//        json此时表示为一个json对象
        String json = objectMapper.writeValueAsString(name);
        System.out.println(json);
        return json;
    }
}
