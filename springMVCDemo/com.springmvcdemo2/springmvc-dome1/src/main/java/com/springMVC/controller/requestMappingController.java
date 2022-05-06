package com.springMVC.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 *
 * ctrl+7可以查看代码中的方法
 * @date 2021/9/3 -14:51
 * requestMapping注解
 * 1.标识一个类 和一个方法
 * （1）标识一个类：设置映射请求的请求路径的初始化信息
 * （2）标识一个方法：设置映射请求请求的具体信息
 *
 * 2.如果requestMapping注解设置在类上和方法上
 * 浏览器需要先访问初始信息再访问具体信息
 *
 * 在html页面的超链接上需要写类上requestMapping注解再写方法上的requestMapping注解
 */
@Controller//注解：成为一个控制器
//@RequestMapping("text")
public class requestMappingController {

//    此时请求映射所映射的请求路径为：/text/success
//    注解中value属性可以设置为 单个字符 或者 一个字符串的数组
//@RequestMapping("/success")
//    即：超链接中的链接符合其中一个则可以进行调转

//    添加请求的方式为get或者post


//    该请求映射能够匹配多个请求地址所对应的请求
@RequestMapping(
        value = {"/test","/success"},
//        设置当前请求的请求地址的请求方式为get方式或者为post方式 ,前端的请求方式符合其中一种就可以匹配到
//        RequestMethod是一个枚举类型
        method = {RequestMethod.GET,RequestMethod.POST}
        )
    public String success(){
        return "success";
    }

//    处理指定请求方式的控制方法：@RequestMapping的派生注解
//    例如：处理get请求的映射：--->@GetMapping
//    不用写@RequestMapping注解，
//    直接写请求映射 请求访问的地址写在value里面
    @GetMapping("/testGetMapping")
    public String testGetMapping(){
        return "success";
    }

    @PostMapping("/testMappingpost")
    public String testPostMappingpost(){
        return "success";
    }


//    @RequestMapping注解中params属性
//    通过请求的请求参数匹配请求映射
//
    @RequestMapping(
            value = {"/testParams"},
//            要求请求地址中要包含 指定的参数
//            {"username"}
//    要求请求地址中不能包含 指定的参数
//           例如 {"!username"}
//            param=value：要求请求映射所匹配的请求必须 param=value
//            例如：username=admin
//            param=value：要求请求映射所匹配的请求的参数等于value不能 !param=value
//            例如:!username=admin

//   代码  请求映射的请求参数比必须出现username和pwd，而且username必须等于root ！pwd不能等于1234
            params = {"username=root","pwd!=1234"},
//            设置头信息 键值对方式 要求请求头信息携带localhost:8080"
            headers = ("host=localhost:8888")
            )
    public  String testParams(){
        return  "success";
    }


//    ant风格的路径
//    ？表示任意的字符  除了“/”
//    @RequestMapping(value = "a?a")

//    *表示任意的0个或多个字符
//@RequestMapping(value = "a*a")
//    **表示任意的一层或者多层
///**/两个**必须单独放在一个/和/
@RequestMapping(value = "/**/a")
    public String testAnt(){
        return "success";
    }

//    测试路径中的占位符 restful风格
//    当请求路径中的某些数据通过
//    路径的方式传输到服务器时，可以在相对应的@RequestMapping注解的value属性
//    中通过占位符{xxx}表示传输的数据，在通过@PathVariable注解，将
//    占位符表示的数据赋值给控制器方法的形参

//    请求地址中的属性名和属性值 直接省略属性名 将属性值直接写在路径里
    @RequestMapping("/testpath/{id}/{username}")
    public String testRest(@PathVariable("id")Integer id,@PathVariable("username")String username){
        System.out.println("id:"+id+",username:"+username);
    return "success";
    }

}
