package com.spring5.annotation注解;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * @date 2021/7/19 -11:29
 * （1）@Component:普通注解
 * （2）@Service：用在业务逻辑层或者service
 * （3）@Controller:用来web层上
 * （4）@Repository：用在DU层 数据持久层
 * 注解功能一样，都可以用来创建Bean实例
 */
//第三步：在类上面添加创建对象注解
// 在注解里面value属性值可以省略不写
//    默认值是类名称，首字母小写
@Controller(value = "userServlet")
//    等于<bean id=userServlet class="..."/>
public class servlet {
    public void test() {
        System.out.println("spring里面的注解");
    }
}
