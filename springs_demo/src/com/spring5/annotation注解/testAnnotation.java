package com.spring5.annotation注解;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @date 2021/7/19 -11:42
 * 测试spring注解
 */
public class testAnnotation {
    @Test
    public void test() {
//        加载配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("annotation.xml");
//        第一个值为注解中的value 第二个值为依赖
        servlet servlet = context.getBean("userServlet", servlet.class);
        servlet.test();
    }
}
