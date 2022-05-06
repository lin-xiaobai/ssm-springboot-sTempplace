package com.spring5.webfiuxdemo.service.Impl;

import com.spring5.webfiuxdemo.entity.User;
import com.spring5.webfiuxdemo.service.UserService;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * @date 2021/8/6 -11:54
 * SpringWebflux(基于注解编程模型）
 * 只需要把相关依赖配置到项目中
 * springBoot自动配置相关运行容器
 * 默认情况下使用 Netty服务器
 *
 */
@Repository  //这个注解：交给spring管理
public class UserServiceImpl implements UserService {

//   创建map集合存储数据
    private  final Map<Integer,User> users=new HashMap<>();

    //    通过无参构造对user实体类进行赋值
    public UserServiceImpl(){
        this.users.put(1,new User("zs","nan",20));
        this.users.put(2,new User("lis","nv",21));
        this.users.put(3,new User("ww","nan",22));
    }
//根据id查询
    @Override
    public Mono<User> getUserById(int id) {
//        Mono.justOrEmpty 声明数据流或者为空
//        返回一个元素或者为空
//        传参为1个id
        return Mono.justOrEmpty(this.users.get(id));
    }

//    查询多个用户
    @Override
    public Flux<User> getAllUser() {
//        返回值是一个集合
//        声明数据流的集合形式
//this.users.values()把map集合中所有值都取出来 然后放到flux中
        return Flux.fromIterable(this.users.values());
    }
//添加用户
//    做法：把userMono 中的值取出 然后放到map集合中
    @Override
    public Mono<Void> saveUserInfo(Mono<User> userMono) {
//        userMono.doOnNext :把里面的值都取出（相当一个遍历）
//      lamba表达式
// 意思：把userMono中的值转成person对象，然后将person放到map中
        return userMono.doOnNext(person -> {
//            向map集合里面放值
//  为了防止map里面的值冲突，然后将map长度+1 作为map的key键
            int id=users.size()+1;//获取map集合中的长度
            users.put(id,person);
//            做终止信号处理，如果没有做终止信号处理，表示这个是一个无限的数据流
        }).thenEmpty(Mono.empty());//做空值处理 将mono中的值清空 表示一个终止处理
    }
}
