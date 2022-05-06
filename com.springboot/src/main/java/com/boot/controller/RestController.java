package com.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @date 2021/11/26 -19:32
 * Rest风格（使用HTTP请求方式动词来表示对资源的操作)
 *  以前：/getUser 获取用户 /deleteUser 删除用户
 *      /editUser 修改用户 /save 保存用户
 *  现在： /user GET请求-获取用户 DELETE请求-删除用户
 *         PUT请求-修改用户 POST请求-保存用户
 *  核心Filter：HiddenHttpMethodFilter
 *      用法：表单method=post,隐藏域 method=put
 */
@Controller
public class RestController {
//    访问路径相同，以请求方式区别 是删除还是修改还是添加还是查询操作
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getUser(){
        return "GET-张三";
    }
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String postUser(){
        return "post-张三";
    }
    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public String putUser(){
        return "put-张三";
    }
    @RequestMapping(value = "/user",method = RequestMethod.DELETE)
    public String deleteUser(){
        return "delete-张三";
    }
}
