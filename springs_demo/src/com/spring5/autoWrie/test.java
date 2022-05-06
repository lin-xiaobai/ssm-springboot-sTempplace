package com.spring5.autoWrie;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @date 2021/7/17 -17:41
 * 测试自动转配
 */
public class test {
    @Test
    public void testAutoWrie() {
        ApplicationContext context = new ClassPathXmlApplicationContext("autoWrie.xml");
//        引入依赖
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);
    }
}
