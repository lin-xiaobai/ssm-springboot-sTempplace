package com.spring5.testSpring5;

import com.spring5.InsideBean.Emp;
import com.spring5.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @date 2021/7/8 -19:37
 */
public class overBeanTest {
    // 测试外部bean （在service类中调用dao类）spring配置文件为objectbean.xml
    @Test
    public void testService() {
//        引用spring中的xml配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("ObjectBean.xml");
//        获取对象,第一个参数为xml文件中创建对象时的id值，第二参数为对象的字节码文件
//        返回值为对象
        UserService service = context.getBean("userservice", UserService.class);
//       通过对象调用方法
        service.add();
    }

    //    测试内部bean 在xml文件中嵌套一个bean
    @Test
    public void testInside() {
        ApplicationContext context = new ClassPathXmlApplicationContext("InsideBean.xml");
        Emp emp = context.getBean("emp", Emp.class);

        System.out.println(emp);
    }

    //    测试级联属性 在spring文件中引入外部bean（对外部bean属性赋值）
    @Test
    public void testjilian() {
        ApplicationContext context = new ClassPathXmlApplicationContext("CascadeAssignmentBean.xml");
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);
    }
}
