package com.spring5.BeanLift;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.EnvironmentCapable;

/**
 * @date 2021/7/15 -18:13
 * 测试bean生命周期
 */
public class test {
    @Test
    public void liftBean() {
//        引入spring的配置文件
//        ApplicationContext context = new ClassPathXmlApplicationContext("BeanLift.xml");

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("BeanLift.xml");
//        获取对象  第一个参数写配置文件中的id值 第二个参数导入依赖
        stu stu = context.getBean("stu", stu.class);
        System.out.println("4.bean可以使用（对象获取到）");
        System.out.println(stu);
//        需手动让bean实例销毁 ,
//        close方法在是子类中特有的，不能使用,而创建ClassPathXmlApplicationContext对象中的是使用多态，
//        而 ApplicationContext中没有关闭容器方法，所以这时候需要强转或者不需要多态
        context.close();
    }
}
