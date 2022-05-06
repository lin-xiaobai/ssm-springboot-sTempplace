package com.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @date 2021/9/11 -18:07
 * springMVC中的视图是View接口，视图作用：渲染数据，将模型Model中的数据展示给用户
 *
 * 视图种类多：转发视图（InternalResourceView）
 * 重定向视图（RedirectView）
 *
 * 若视图技术为：Thymeleaf,在springMVC的配置文件中配置了
 * Thymeleaf的视图解析器，由此视图解析器解析之后所得到的的是ThymeleafView
 *
 *
 *
 * 转发和重定向的区别：
 * 1.转发：1次请求 发生在服务器内部的
 *
 * 请求不能跨域，重定向可以跨域
 * 原因：转发是发生在服务器内部的，只能访问服务器内部的资源
 * 重定向是浏览器发送2次请求，通过浏览器可以访问很多资源，比如在工程里面重定向到百度
 *
 * 2.重定向：2次请求 浏览器发送2次请求
 * 重定向不能访问到WEB-INF目录下的文件，因为WEB-INF目录具有安全性和隐藏性，只能通过服务器内部进行访问，不能通过浏览器访问
 */
//控制器
@Controller
public class test_viev {
//    因为控制器中只需要跳转到另一个页面，所以可以在springMVC的核心配置文件xml文件配置 view-controller标签
////    控制跳转的页面
//    @RequestMapping("/test_viev")
//    public String test_viev(){
//        return "test_viev";
//    }
//    测试ThymeleafView
//    控制器方法中所设置的视图名称没有任何前缀时，视图名称会被SpringMVC配置文件中所配置的视图解析器
//    解析，视图名称拼接视图前缀和视图后缀所得到的最终路径，会通过  转发 的方式实现跳转
    @RequestMapping("/testThymeleafView")
    public String testThymeleafView(){
//        在视图解析器添加前缀和添加后缀
        return "success";
    }

//    测试转发视图是InternalResourceView
//    创建转发视图的情况：
//    当控制器方法中所设置的视图名称为“forward”为前缀时，创建InternalResourceView视图，
//    此时的视图名称不会被springMVC配置文件的视图所解析，而是会将前缀“forward”去掉，剩余部分作为最终路径通过转发的方式实现跳转

//    地址栏显示的是testForward
    @RequestMapping("/testForward")
    public String testForward(){
//        forward:+要转发的资源路径
        return "forward:/testThymeleafView";
    }

    //    测试重定向视图是RedirectView视图
//    创建重定向视图的情况：
//    当控制器方法中所设置的视图名称为“Redirect:”为前缀时，创建RedirectView视图，
//    此时的视图名称不会被springMVC配置文件的视图所解析，而是会将前缀“Redirect”去掉，剩余部分作为最终路径通过重定向的方式实现跳转



//  重定向的地址 (浏览器发送两次请求，所以有两个请求域)  地址栏显示的是最终的页面 success
    @RequestMapping("/testredirect")
    public String testredirectd(){
 //    重定向不能访问到WEB-INF目录下的文件，因为WEB-INF目录具有安全性和隐藏性，只能通过服务器内部进行访问，不能通过浏览器访问
//
//    需要重定向 到 转发的页面上
//        return  "redirect:/":表示访问根目录


        return  "redirect:/testThymeleafView";
    }
}
