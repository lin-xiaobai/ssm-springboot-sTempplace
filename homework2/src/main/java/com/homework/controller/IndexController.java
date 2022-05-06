package com.homework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @date 2021/12/16 -20:00
 */
@Controller
public class IndexController {
    @GetMapping(value="/login")
    public String login(){
        return "login";
    }
    @RequestMapping("/index")
    public  String index(){
        return "index";
    }
}
