package com.spring5.AopAnnotation;

import org.springframework.stereotype.Component;

/**
 * @date 2021/7/20 -19:27
 */
//被增强的类

//    以注解的方式创建对象 默认为 第一个字母小写的类名称
@Component(value = "user")//普通注解
public class User {
    public void add() {
        System.out.println("add.....");
    }
}
