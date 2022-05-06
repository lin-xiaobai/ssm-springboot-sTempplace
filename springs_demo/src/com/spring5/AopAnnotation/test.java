package com.spring5.AopAnnotation;

import com.spring5.AopByXML.book;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @date 2021/7/20 -20:04
 * <p>
 * <p>
 * 测试：Aop操作中 Aspect+spring
 * 目的：降低代码耦合度，实现多个业务的分离，逻辑更清晰
 */
public class test {
    @Test
    public void testAopAnno() {
//        加载配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("AOPAndAspectAnno.xml");
//      被增强的类
        User user = context.getBean("user", User.class);
        user.add();

    }

    //使用完全注解，配置一个注解类
    @Test
    public void testAllAopAnno() {
//        加载配置文件
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
//      被增强的类
        User user = context.getBean("user", User.class);
        user.add();

    }

    //    xml配置文件
    @Test
    public void testXml() {
//        加载配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("AOPByXml.xml");
//      被增强的类
        book book = context.getBean("book", book.class);
        book.name();

    }
}
