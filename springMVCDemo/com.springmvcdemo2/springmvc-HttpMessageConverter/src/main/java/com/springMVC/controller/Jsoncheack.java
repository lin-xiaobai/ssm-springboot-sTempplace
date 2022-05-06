package com.springMVC.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @date 2021/10/8 -18:13
 */
@Controller
public class Jsoncheack {
    @RequestMapping("/ajax1")
    public  String ajaxA(){
        return "ajaxAddjson";
    }

    @RequestMapping("/axpul")
    @ResponseBody //返回值的视图名称 变为 响应报文的信息体
//    @RequestParam与前端传来的name属性值相匹配，并且赋给形参定义的值
    public String ajaxtow(@RequestParam("username") String username) throws JsonProcessingException {
        System.out.println(username);
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
