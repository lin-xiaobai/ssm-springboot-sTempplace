package com.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * @date 2021/9/6 -18:43
 */
//控制器
@Controller
public class testRequestController {


//  原生的servletApi
    @RequestMapping("/testrequestAPI")
//    request表示当前请求
    public String testrequestAPI(HttpServletRequest request){
//        设置会话session
        HttpSession session = request.getSession();
        String name= request.getParameter("username");
       String pwd=request.getParameter("pwd");
        System.out.println(name+":"+pwd);
        return "success";
    }

//    测试使用控制器的形参获取请求参数
//    前端的name属性需要和控制器的形参的类型名相同，不然就获取不到属性值

//    解决前端的name属性和形参中属性名不相等的时候
    @RequestMapping("/testRequestParm")
//    请求的参数中如果是单字符串的则需要string类型接收
//    请求的参数中如果出现多个同名的请求参数，可以使用控制器方法的形参设置为字符串类型或字符串数组接收。返回的是数组的地址,需要解析
//    public String testRequestParm(String username,String pwd,String hobby){

//    解决前端的name属性和形参中属性名不相等的时候，前端的属性会映射不到后端
//    前端user_name，形参username
//    @RequestParam注解：1.value属性
//    2.required,如果为true，前端没有发送值则报400，选择属性是否为必要有属性值，默认是true，如果前端没有填写则报错，可以修改为false，当为false时，
//    如果前端发送的是一个空的属性值时不会报错
//    3.默认值defaultValue:当前端发送的属性中没有值会默认为此赋上 false值
    public String testRequestParm(
            @RequestParam(value = "user_name",required = false,defaultValue = "fale") String username,
            int pwd,
            String hobby[],
//@RequestHeader将头信息和控制器方法的形参创建映射关系
//    属性value required defaultValue
//      用法跟@RequestParam一样
            @RequestHeader(value = "host")String host,
 //@RequestHeader将头信息和控制器方法的形参创建映射关系
//    属性value required defaultValue
//      用法跟@RequestParam一样
@CookieValue("JSESSIONID")String jsessionid){
        System.out.println(username+":"+pwd+":"+ Arrays.toString(hobby));
        System.out.println(host);
        System.out.println(jsessionid);
        return  "success";
    }
}
