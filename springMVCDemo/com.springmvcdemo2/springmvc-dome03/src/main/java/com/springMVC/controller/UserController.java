package com.springMVC.controller;

import com.springMVC.Bean.userBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @date 2021/9/12 -18:10
 *
 *RESTFul类似于一种协议或者风格
 * 例如
 * 传统的地址符需要传参时（地址符后面？+属性名和属性值）需要使用 /user?id=1&psd=123
 * 使用RESTFul风格时只需要将 属性值 拼接到地址栏后面   /user/1/123
 *
 * RESTFul模拟操作用户资源（增删改查）
 *
 * /users GET 查询所有用户的信息
 * /user/id GET 根据用户id查询用户信息
 * /user  POST 添加用户信息
 * /user/1 DELETE  删除用户信息
 * /user  PUT 修改用户信息
 */
//控制器
@Controller
public class UserController {
//   因为只需要跳转到 test_viev页面，所以在springMVC的配置xml文件中配置了
//    代码等同于
//    @RequestMapping("/test_RESTFul")
//    public String test_RESTFul(){
//        return "/test_RESTFul";
//    }
//    查询所有用户的信息
    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public String getAllusers(){
        System.out.println("查询所有人的信息");
        return "success";
    }


//    当请求路径中的某些数据通过
//    路径的方式传输到服务器时，可以在相对应的@RequestMapping注解的value属性
//    中通过占位符{xxx}表示传输的数据，在通过@PathVariable注解，将
//    占位符表示的数据赋值给控制器方法的形参
    //    请求地址中的属性名和属性值 直接省略属性名 将属性值直接写在路径里
//    根据id查询用户信息
// 多个值：@RequestMapping("/testpath/{id}/{username}")
    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public String getuser(@PathVariable("id")String id){
        System.out.println("用户的id"+id);
        return "success";
    }

//    添加用户信息 post请求
//    控制器方法里的形参是前端的name属性
    @RequestMapping(value = "/user",method = RequestMethod.POST)
//    public String addUser(String username,String pwd){
//    控制器方法里的形参是bean类，对前端的username和pwd属性名进行封装成类
//    类中的属性名和前端的表单中input属性名一致
      public String addUser(userBean user){
//        System.out.println(username+":"+pwd);
        System.out.println("增加的"+user);
        return "success";
    }


////    修改信息   .
// 前端的form表单不支持put请求，如果要设置put请求
// 得需要在xml文件中配置HiddenHttpMethodFilter过滤器
//   修改信息，如果请求方式设置为put请求 如果没有配置的话会默认使用get请求，则在控制器类中调用 get请求的控制器方法
//    即：   查询所有用户的信息 的 控制器类

//    需要做：1.在web.xml文件中设置HiddenHttpMethodFilter过滤器
//2.表单的请求方式设置为post请求
//3.设置一个隐藏的input标签，name的属性是一个常量：_method 还有属性值设置为put（大小写都可以） 作用：对当前的请求进行转换
//
    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public String updateUser(String username,String pwd){
        System.out.println("修改的用户名"+username+":"+"pwd="+pwd);
        return "success";
    }

}
