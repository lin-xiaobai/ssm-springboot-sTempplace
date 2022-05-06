package com.spring5.FactoryBean;

import com.spring5.student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @date 2021/7/14 -19:12
 * 测试工厂factory：修改返回类型
 * 本来是mybean类型，经过xiuGeiReturn类中修改返回值类型
 */
public class test {
    @Test
    public void testReturn() {
        ApplicationContext context = new ClassPathXmlApplicationContext("FactoryBean.xml");
//测试单实例（在栈中只创建一个对象 两个对象的地址符都相同 ）还是多实例（需要在配置文件中scope中配置值）
        student obj1 = context.getBean("factory", student.class);
        student obj2 = context.getBean("factory", student.class);
        System.out.println(obj1);
        System.out.println(obj2);
    }
}
