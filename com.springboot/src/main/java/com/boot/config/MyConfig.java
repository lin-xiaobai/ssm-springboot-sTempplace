package com.boot.config;

import ch.qos.logback.core.db.DBHelper;
import com.boot.bean.Car;
import com.boot.bean.Pet;
import com.boot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * @date 2021/11/5 -20:46
 * 配置类里面使用@Bean标注在方法上给容器注册组件，默认使用单实例
 * 单实例：无论获取多少次组件（对象），他的内存地址是不变的
 */
//
//    1.等同于配置文件（bean.xml）
//    往IOC容器中添加组件
//    配置类MyConfig类也是一个组件

//    2.proxyBeanMethods:代理bean的方法 默认为true
//    全配置Full(proxyBeanMethods = true)、
//    【保证每个@Bean方法被调用多少次返回的组件都是单实例的】
//     轻量级Lite(proxyBeanMethods = false)【每个@Bean方法被调用多少次返回的组件都是新创建的】
//     组件依赖必须使用Full模式默认。其他默认是否Lite模式

//   组件依赖：当组件中存在另一个组件的引用时，可以直接使用容器中的组件，不需要新创建
//    例如：user组件中存在一个pet组件的引用，user组件可以直接获取容器中的组件

//    proxyBeanMethods = false的好处是每次启动很快，因为不需要去调用类中的组件，等需要使用组件的时候再去启动

//   3.@Import({}) 给容器中自动创建出这两个类型的组件、默认组件的名字就是全类名
// 例如@Import({User.class}) Import注解创建的User类型的组件名字是com.boot.bean.User

//   4.@Conditional()条件转配：满足Conditional指定的条件，则进行组件注入
//    @Conditional里面有很多子注解
//@ConditionalOnBean(name = "cat"):如果容器中不存在名为cat的组件时，则不将下面方法的组件注册到容器中
//
// 注意：@ConditionalOnBean(name = "cat") 可以添加在方法和类上，
// 添加到类上则表示:如果容器中存在名为cat的组件时，则执行类中的方法，将方法的返回值的组件添加到IOC容器中
//    当@ConditionalOnBean(name = "cat")的条件注解 满足时，再执行往容器中添加组件的操作，
//    如果不符合则不执行操作

//给容器中创建user类型和dbhelper类型的组件
@Import({User.class, DBHelper.class})

@Configuration(proxyBeanMethods = true)//告诉springBoot这个是一个配置类

//1.开启car配置绑定功能
//2.把car这个组件自动注册到容器中
//3.需要在对应的javaBean类上添加@ConfigurationProperties(prefix = "mycar")注解
//自动去  Properties配置文件 中 解析 前缀名为mycar的键值对，进行数据绑定
@EnableConfigurationProperties(Car.class)

//6.导入spring的配置文件，将配置文件解析然后放到容器中，类路径下中的beans.xml文件
@ImportResource("classpath:beans.xml")
public class MyConfig {

    /**proxyBeanMethods为true时，
     * 外部无论对配置类中的这个组件注册方法调用多少次获取的都是之前注册日容器中的单实例对象
     * @return
     */
// 需求：当容器中存在名为cat组件时，再给容器注入名为user01的组件
//    如果容器中不存在名为cat组件时，则不给容器注入名为user01的组件
    @ConditionalOnBean(name = "cat")
    @Bean//给容器中添加组件
//    以方法名作为组件的名字 返回类型就是组件的类型
//    返回的值，就是组件在容器中的实例
    public User user01(){
        User user = new User("张三", 18);
//        user组件依赖了pet组件
//        得设置代理对象 即proxyBeanMethods = true
        user.setPet(cat());
        return user;
    }
    @Bean("tom")//往容器中添加自定义组件名为tom的pet组件，并且实例化
    public Pet tomcat(){
        return new Pet("tomcat");
    }

//    注销组件名为cat
    @Bean("cat")
    public Pet cat(){
        return new Pet("cat");
    }
}
