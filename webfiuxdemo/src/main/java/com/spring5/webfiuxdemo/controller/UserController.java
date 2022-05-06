package com.spring5.webfiuxdemo.controller;

import com.spring5.webfiuxdemo.entity.User;
import com.spring5.webfiuxdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @date 2021/8/6 -20:40
 */

@RestController //交给spring管理
public class UserController {
//    注入service
    @Autowired
    private UserService userService;

//    id查询 单元素
//    /user：起名  /{id}：传入id值
    @GetMapping("/user/{id}")
//    @PathVariable：得到路径中id值
    public Mono<User> getUserId(@PathVariable int id){
        return userService.getUserById(id);
    }
//    GetMapping:get请求
//    查询所有  多个元素
//设置访问是get请求，路径名为user
    @GetMapping("/user")

    public Flux<User> getUsers(){
        return userService.getAllUser();
    }
//    添加
//   @PostMapping：post请求 名为save
    @PostMapping("/saveuser")
//    @RequestBody :传递对象
    public Mono<Void>saveUser(@RequestBody User user){
//        Mono.just(user)：声明数据流
//        将user对象转变为Mono
            Mono<User> userMono=Mono.just(user);
            return  userService.saveUserInfo(userMono);
    }
}
