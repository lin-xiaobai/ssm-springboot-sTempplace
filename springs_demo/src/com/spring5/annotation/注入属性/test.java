package com.spring5.annotation.注入属性;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @date 2021/7/19 -16:37
 * 测试以注解方式注入属性
 */
public class test {
    @Test
    public void testBeanByType() {
        ApplicationContext context = new ClassPathXmlApplicationContext("annotationAddBean.xml");
        server server = context.getBean("server", server.class);
        server.add();
    }

    //    测试完全注解
    @Test
    public void testAll() {
//        加载配置类,不用加引号
//        区别：子接口替换成AnnotationConfigApplicationContext，参数替换成字节码文件
        ApplicationContext context = new AnnotationConfigApplicationContext(config.class);
        server server = context.getBean("userServer", server.class);
        server.add();
    }
}
