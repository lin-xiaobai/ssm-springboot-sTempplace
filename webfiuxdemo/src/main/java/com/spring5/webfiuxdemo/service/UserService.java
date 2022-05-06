package com.spring5.webfiuxdemo.service;

import com.spring5.webfiuxdemo.entity.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @date 2021/8/6 -11:44
 * 现在是使用Webflux，里面是根据
 *
 * 区别之前：一个元素用 Mono 多个元素用 Flux
 */
//用户操作接口
public interface UserService {

//    Mono是返回0或者一个元素
//    Flux返回多个对象或者多个值<多个元素>
//    根据id查询用户 id查询是主键 一般都是返回一个对象或者一个值
    Mono<User> getUserById(int id);

//    查询所有用户
    Flux<User> getAllUser();

//    添加用户 void 表示没有返回值 传参是一个对象
    Mono<Void> saveUserInfo(Mono<User> user);
}
