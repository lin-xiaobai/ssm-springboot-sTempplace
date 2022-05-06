package com.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @date 2021/9/2 -18:46
 *
 */
//通过注解加xml文件扫描组件（需要在spring的xml文件中创建扫描组件），创建一个控制器。
// 通过扫描让springMVC明白这个是一个控制器
//    将当前类中的方法作为一个控制器方法，来控制当前请求和响应
@Controller
public class helloController {
//    访问的路径是"/" 就会跳转到--> /WEB-INF/templates/index.html

//    控制器里面的方法才是真正处理请求的方法
//    创建一个方法，返回值是string，方法名随便写
//    当前请求，然后匹配到这个方法时，跟方法名是没有关系的

//    意思是当浏览器请求的路径是"/",也就是上下文路径的时候就会来实现 注解中的标识的方法，
//    通过视图名称加上视图解析器中的前缀和后缀就可以跳转到 指定的页面
    @RequestMapping(value= "/")  //请求映射的注解
//    注解的作用：将当前的请求和控制器方法来创建映射关系
    public String index(){
//        返回视图名称  视图名称决定了最终跳转的页面
//        视图名称 会被 xml文件 中 视图解析器进行解析
//        加上前缀(/WEB-INF/templates/)和加上后缀(.html) 后就是最终 要访问的页面
        return "index";
    }


//    创建一个控制器 返回值是target页面的视图名称target
//注解中的value值 需要和 html中的超链接中 绝对路径 相同
    @RequestMapping("/target")
    public String target(){
//        视图名称 在xml文件中自动添加前缀和后缀
        return "target";
    }

 //    测试请求参数首页的访问路径控制器
    @RequestMapping("/param")
    public String parm(){
        return  "test_requestParm";
    }

}
