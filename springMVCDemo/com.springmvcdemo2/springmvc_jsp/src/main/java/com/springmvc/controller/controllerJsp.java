package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @date 2021/9/11 -20:52
 */
//控制器
@Controller
public class controllerJsp {
//    因为控制器中只需要跳转到另一个页面，所以可以在springMVC的核心配置文件xml文件配置 view-controller标签

    //    跳转到success.jsp页面
//    @RequestMapping("/success")
//    public String success(){
////  返回值为视图名称 到jsp的视图解析器的xml文件 添加前缀和后缀后就可以跳转
//        return "success";
//    }
////    @RequestMapping("/index2")
//    public  String testindex(){
//        return "index2";
//    }
}
