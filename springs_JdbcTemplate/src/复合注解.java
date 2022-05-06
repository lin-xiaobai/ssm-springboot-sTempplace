import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import com.spring5.bank.service;
import org.junit.jupiter.api.Test;

/**
 * @date 2021/8/3 -23:11
 * 复合注解代替上面两个注解完成整合
 */
@SpringJUnitConfig(locations = "classpath:ByAnnotion.xml")
//整合了
//加入测试的版本 指定单元测试框架 JUnit5版本
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration("classpath:ByAnnotion.xml") //加载配置文件


public class 复合注解 {
    @Autowired
    private service service;

    @Test
    public void test() {
        service.count(100);
    }

}
