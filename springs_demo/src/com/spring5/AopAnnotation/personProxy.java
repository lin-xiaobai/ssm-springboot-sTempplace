package com.spring5.AopAnnotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @date 2021/7/20 -23:43
 * 多个增强类对同一个方法进行增加，设置增强类优先级
 */
//在增强类上面添加@Order(数字类型值)，数字类型越小优先级越高
//    增强类：需要设置创建对象注解 创建增强类
@Component//创建对象注解
@Aspect//定义增强类
@Order(1)//设置增强类优先级
public class personProxy {
    @Before(value = "execution(* com.spring5.AopAnnotation.User.add(..))")
//        设置增强方法
    public void person() {
        System.out.println("person before...");
    }

}
