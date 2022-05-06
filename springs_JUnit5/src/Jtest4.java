//import org.junit.Test;
//import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.spring5.bank.service;

/**
 * @date 2021/8/3 -22:07
 * <p>
 * spring5支持整合JUnit5
 * 整合：使用spring注解IOC反射，去实例化JUnit4
 * 好处：测试几千个测试方法较简单
 * <p>
 * 测试类中的 spring中的JUnit框架
 */
//加入测试的版本 指定单元测试框架 哪个JUnit版本
//@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration("classpath:ByAnnotion.xml") //加载配置文件
//等同于
// ApplicationContext context=new ClassPathXmlApplicationContext("ByAnnotion.xml");

public class Jtest4 {

    @Autowired //直接注入属性
    private service service;
//    等同于
//service services=  context.getBean("service",service.class);

    //    测试类
//    @Test
    public void test1() {
        service.count(100);
    }

}
