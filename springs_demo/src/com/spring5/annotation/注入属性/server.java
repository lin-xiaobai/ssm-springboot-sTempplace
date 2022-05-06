package com.spring5.annotation.注入属性;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

/**
 * @date 2021/7/19 -16:37
 * 基于注解方式实现属性注入  在server调用dao
 * 1.@Autowired:根据 属性 类型进行自动装配
 * 第一步 把service和dao对象创建，在service和dao类添加创建对象注解
 * 第二步 在service注入dao对象，在service类中添加dao类型属性
 * 在属性上面使用注解
 */
//创建对象注解
@Controller(value = "userServer")
public class server {

    //    注入普通属性
    @Value(value = "abc")
    private String name;


//    定义dao属性
//    注解中不需要添加set方法
//    添加注入属性注解


    @Autowired//根据类型进行注入
    //@Qualifier：根据名称进行注入
//  这个 @Qualifier注解的使用和上面 @Autowired 一起使用
//   value的值需要和 dao类中的注释id一样
    @Qualifier(value = "userDao")//根据名称进行注入
    private dao userdao;


    public void add() {
        System.out.println("service add...." + name);
        userdao.testDao();
    }

}
