import com.spring5.bank.service;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @date 2021/8/3 -22:07
 * <p>
 * spring5支持整合JUnit5
 * 整合：使用spring注解IOC反射，去实例化JUnit4 单纯使用JUnit4还得手写代码
 * 好处：测试几千个测试方法较简单
 * <p>
 * 测试类中的 spring中的JUnit5框架
 */
//加入测试的版本 指定单元测试框架 JUnit5版本
@ExtendWith(SpringExtension.class)

@ContextConfiguration("classpath:ByAnnotion.xml") //加载配置文件
//等同于
// ApplicationContext context=new ClassPathXmlApplicationContext("ByAnnotion.xml");

public class JUnitTest5 {

    @Autowired //直接注入属性
    private service service;
//    等同于
//service services=  context.getBean("service",service.class);

    //    测试类
    @Test
    public void test1() {
        service.count(100);
    }

}
