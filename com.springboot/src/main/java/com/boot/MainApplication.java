package com.boot;

import com.boot.bean.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @date 2021/11/1 -18:31
 * 主程序类
 */
//   @SpringBootApplication里面配置了默认扫描注解包，
//   即主程序所在包及其下面的所有子包里面的组件都会被默认扫描进来
// 扩展：如果想要扫描主程序所在包的 其他包，则需要在@SpringBootApplication注解外夸大 包扫描的范围
//    想要改变扫描路径，@SpringBootApplication(scanBasePackages="com.boot")
//    或者@ComponentScan 指定扫描路径

//@SpringBootApplication //表明这个是一个springboot应用
//以上的三个注解是 @SpringBootApplication注解 的 核心注解 ，可以具体使用这三个注解代替@SpringBootApplication注解
@SpringBootConfiguration//@Configuration。代表当前是一个配置类
@EnableAutoConfiguration
@ComponentScan("com.boot")//指定扫描哪些，Spring注解；
public class MainApplication {
    public static void main(String[] args) {
//        1.返回IOC容器（ConfigurableApplicationContext）
//        （容器中包含当前应用的所有组件）
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);
//      2.查看容器里面的组件
//      getBeanDefinitionNames()：获取组件定义的名字
//      beanDefinitionNames：存放的是组件名字的数组
        String[] beanNames = run.getBeanDefinitionNames();
//        查看容器中的组件
//        for (String name:beanNames) {
//            System.out.println(beanNames);
//        }
//        3.从容器中获取组件 使用bean组件的id获取
//        Pet tom1 = run.getBean("tom", Pet.class);
//        获取组件id为cat的组件
//        Pet cat = run.getBean("cat", Pet.class);
////        判断两个组件的内存地址是否相同
//        System.out.println(tom1==cat);
//        System.out.println(tom1+":"+cat);
//        4.验证配置类是否为一个组件
//        MyConfig config = run.getBean(MyConfig.class);
//        System.out.println(config);

//        5.如果配置类中的@Configuration(proxyBeanMethods = true)代理对象调用方法
//        代理对象调用方法的类：com.boot.config.MyConfig$$EnhancerBySpringCGLIB$$fb3aeedc@1868997
//        不是代理对象调用方法的类：com.boot.config.MyConfig@9f5dd8

//        sringBoot总会检查这个组件是否在容器中
//        总之就是为了保持组件单实例
//        User user = config.user01();
//        User user1=config.user01();
//        如果是代理对象调用方法的话是true，即两个组件是相同的
//        即@Configuration(proxyBeanMethods = true)
//        如果不是代理对象调用方法的话是false,两个组件都是新创建的
//        即@Configuration(proxyBeanMethods =false)
//        System.out.println(user == user1);

//     6.在注解的@Configuration(proxyBeanMethods = true)中
//     判断user组件是否依赖pet组件
//        User user01 = run.getBean("user01", User.class);
//        Pet cat1=run.getBean("cat",Pet.class);
//        System.out.println("用户的宠物："+(user01.getPet()==cat1));

//        7.实验 使用@Import()进行创建组件,默认组件的名字是全类名
//        获取id为 dbhelper类型的组件
//      run.getBeanNamesForType:获取容器中所有User类型的组件
        String[] beanNamesForType = run.getBeanNamesForType(User.class);
        for (String s:beanNamesForType) {
            System.out.println(s);
        }

//        8.判断容器中是否存在名为cat的组件
        boolean cat = run.containsBean("cat");
        System.out.println("IOC容器中是否存在cat组件："+cat);
//        判断容器中是否存在名为user01的组件
        boolean user01 = run.containsBean("user01");
        System.out.println("IOC容器中是否存在user0组件："+user01);


//        9.当条件注解中@ConditionalOnBean(name="tom")添加在类上，而条件的在类中的方法里，
//        判断是否能够先执行类中的方法，获得条件，然后在判断类中的条件注解
//        总归就是判断：注册组件的顺序
        boolean tom = run.containsBean("user");
        System.out.println("判断条件注解在类上，而且条件在方法上"+tom);

//        10.@ImportResource("classpath:beans.xml")
//       放在类上表示 导入spring的配置文件，将配置文件的配置(注册组件等操作)解析然后放到容器中
//        判断容器中是否存在配置文件中组件注册的配置
        boolean hh = run.containsBean("hh");
        System.out.println("hh:"+hh);
        boolean xx = run.containsBean("xx");
        System.out.println("xx:"+xx);
    }
}
