package com.spring5.testSpring5;

import com.spring5.User;
import com.spring5.book;
import com.spring5.orders;
import com.spring5.student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.awt.print.Book;

/**
 * @date 2021/6/30 -19:47
 * 测试spring5的代码
 * 调用user类中的方法
 */
public class testSpring5 {

    //    引入test包
    @Test
    public void testAdd() {
//        加载spring配置文件
//        因为spring配置文件在src路径下就直接调用ClassPathXmlApplicationContext
//        或者
//        FileSystemXmlApplicationContext() 入参是spring配置文件的路径

//       如果不在src下入参写路径   如果在src下入参是配置文件的名称或者路径
        ApplicationContext context = new ClassPathXmlApplicationContext("UserBean.xml");

//        获取配置创建的对象
//        第一个入参是xml文件中id的值，第二参数是转换类型
        User user = context.getBean("user", User.class);

        System.out.println(user);
//        调用user类中的方法
        user.add();

    }

    //    加注解是为了说明这个是一个测试类
//    测试配置属性注入
//    测试spring配置文化配置对象创建，set方法注入属性
    @Test
    public void testbook() {
        ApplicationContext context = new ClassPathXmlApplicationContext("UserBean.xml");
        book book = context.getBean("book", book.class);
        System.out.println(book);
        book.test();
    }

    //    测试 有参构造方法 注入属性
    @Test
    public void testOrders() {
        ApplicationContext context = new ClassPathXmlApplicationContext("UserBean.xml");
//        获取orders对象
        orders order = context.getBean("orders", orders.class);
        System.out.println(order);
    }

    //    测试 p名称空间注入
    @Test
    public void testStudent() {
        ApplicationContext context = new ClassPathXmlApplicationContext("UserBean.xml");
        student student = context.getBean("student", student.class);
        System.out.println(student.toString());
    }
}
