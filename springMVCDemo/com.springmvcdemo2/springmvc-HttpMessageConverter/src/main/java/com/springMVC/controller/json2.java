package com.springMVC.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springMVC.bean.UserBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @date 2021/10/7 -20:56
 */
@Controller
public class json2 {
    @RequestMapping("/js")
    public  String js(){
        return "json";
    }
    @RequestMapping("/json")
    @ResponseBody
    public  UserBean jsontest(){
        return new UserBean(110,"林",0);
    }
    @RequestMapping("/ajax")
    public String ajax(){
        return "ajaxandjson";
    }

//    前端传来ajax请求，只需要在控制器添加 responsebody注解，将返回值修改成返回类型，而不是返回一个视图名称
//向浏览器传输数据 响应浏览器数据
//    @ResponseBody用于标识一个控制器方法，将该方法的返回值直接作为报文的响应体响应到浏览器
    @RequestMapping(value = "/ax",method = RequestMethod.POST)
    @ResponseBody
    public String ajaxjson(@RequestParam("username") String username) throws JsonProcessingException {
        System.out.println(username);
//        创建一个map集合  保存 用户名是否存在 状态
        Map<String,Object> map=new HashMap<>();
//        判断用户名是否存在
        if("admin".equals(username)){
            map.put("exit",true);//ture表示存在
            map.put("message","此用户已经存在");
        }else {
            map.put("exit",false);
            map.put("message","此用户不存在");
        }
//        将map集合保存为一个json格式数据 jackson框架
        ObjectMapper objectMapper=new ObjectMapper();
        String ms = objectMapper.writeValueAsString(map);
//        将json格式的数据响应到服务器中去
        return ms;
    }

}
