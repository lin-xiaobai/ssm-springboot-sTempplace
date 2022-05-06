package com.spring5.bank;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @date 2021/7/24 -12:08
 * 事务操作
 * 1.事务添加到JavaEE三层结构里面Service层(业务逻辑层)
 * 2.在spring进行事务管理操作
 * （1）两种方式：编程式事务管理和声明式事务管理（使用）
 * 3声明式事务管理
 * （1）基于注解方式
 * （2）基于xml配置文件方式
 * <p>
 * 4.在Spring进行声明式事务管理，底层使用AOP原理
 * <p>
 * 5.Spring事务管理API
 */
public class test {
    @Test
//    测试没事务的转账
    public void testMoney() {
//        加载配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("ByAnnotion.xml");
        service services = context.getBean("service", service.class);
//
        int money = 100;
        services.count(money);
    }

    //    使用xml文件进行事务的配置
    @Test
    public void testByXml() {
        ApplicationContext context = new ClassPathXmlApplicationContext("ByXml.xml");
        service service = context.getBean("service", service.class);
        int money = 100;
        service.count(money);
    }

    //    使用完全注解方式进行事务的配置
    @Test
    public void testAll() {
        ApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);
        service service = context.getBean("service", service.class);
        int money = 100;
        service.count(money);
    }

}
