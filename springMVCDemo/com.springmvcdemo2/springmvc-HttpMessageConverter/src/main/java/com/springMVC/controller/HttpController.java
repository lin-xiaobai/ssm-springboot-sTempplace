package com.springMVC.controller;

import com.springMVC.bean.UserBean;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * @date 2021/10/7 -17:06
*
 */
//@RestController //复合注解 标识在控制器的类，相当于为类添加了
//@Controller注解，并且为其中的每个方法都添加上了@ResponseBody注解
@Controller
public class HttpController {
//    @RequestBody可以获取请求体，需要在控制器方法设置一个形参，使用@RequestBody进行标识，
//    当前请求的请求体就会为当前注解所标识的形参赋值
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String requestBody, Model model){
        System.out.println("使用请求报文注解的信息"+requestBody);
        model.addAttribute("success",requestBody);
        return "success";
//        将报文信息传到成功页面显示
    }
//   RequestEntity类型 封装请求报文的一种类型，需要在控制器方法的形参中设置该类型的形参，当前请求的请求报文
//    就会赋值给该形参，可以通过getHeaders()获取请求头信息，

    @RequestMapping("/testRequestEntity")
//    指定类型为string类型
    public String testRequestEntity(RequestEntity<String> requestEntity){
//        requestEntity是继承HttpEntity
        System.out.println("请求的头信息"+requestEntity.getHeaders());
        System.out.println("请求体的信息"+requestEntity.getBody());
        System.out.println("请求体类型"+requestEntity.getType());
        System.out.println("请求体url"+requestEntity.getUrl());
        return "success";
    }

//测试原生servletAPI响应数据到浏览器
    @RequestMapping("testResponse")
//    形参中是以servletAPI中设置一个响应对象
    public void testResponse(HttpServletResponse response) throws IOException {
//        getWriter :以流的形式
//        print（）:方法里面的内容以 响应体直接输出到页面上
        response.getWriter().print("heelwork");
    }
//    向浏览器传输数据 响应浏览器数据
//    @ResponseBody用于标识一个控制器方法，将该方法的返回值直接作为报文的响应体响应到浏览器
    //测试springmvc中响应数据到浏览器
    @RequestMapping("/testResponseBody")
    @ResponseBody//添加这个注解后， 控制器方法的返回值就不是 视图解析器名称了，而是一个数据类型（可以发送json对象的数据）

//    eg:返回值类型是string类型
    public  String testResponseBody(){
        return "testResponseBody";
    }

/**
 *浏览器支持json格式的数据和文本 不接受java对象，因为浏览器无法解析java对象，http协议（规范前端和后端之间的数据）
 *json：数据交换格式 json对象{} json数组[]
 * 使用ResponseBody处理json步骤
 * 1.在springmvc.xml导入jackson框架的依赖
 * 2.在springmvc.xml的核心配置文件中开启mvc的注解驱动，此时在HandlerAdaptor中会自动
 * 装配一个信息转换器：Mappingjackson2HttpMessageConverter，可以将响应到浏览器
 * 的java对象转换为json格式的字符串
 *springmvc.xml： <mvc:annotation-driven />
 * 3.在控制器方法上使用@ResponseBody注解进行标识
 * 4.将java对象直接作为控制器方法的返回值返回，就会自动转换为json格式的字符串
 */
//测试使用jsckson框架将java对象转换为json的数据格式 然后向浏览器响应json数据
@RequestMapping("/testResponseBodybyJson")
@ResponseBody
public UserBean testResponseBodybyJson(){
    return new UserBean(110,"林",0);
}







//springmvc处理ajax的控制器方法
    @RequestMapping("/testVueAxios")
    @ResponseBody //这个注解标识的控制器方法表示返回值是一个string类型
//    前端传来的数据一个叫username和一个叫password，所以需要在形参位置上设置一个与它同名的属性
//    通过name属性名匹配
    public String testVueAxios(String username,String password){
        System.out.println(username+":"+password);
        return "heelo,ajax";
    }

}
