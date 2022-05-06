package com.spring5.AopAnnotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @date 2021/7/21 -10:32
 * 配置类
 * aop注解中使用完全注解方式（不需要插件XML配置文件）
 */
@Configuration //声明这个是一个配置类
@ComponentScan(basePackages = {"com.spring5.AopAnnotation"})//开启组件扫描
//默认值为false
//等同于 xml配置文件中： <aop:aspectj-autoproxy></aop:aspectj-autoproxy>
@EnableAspectJAutoProxy(proxyTargetClass = true)//开启Aspect生成代理对象

public class Config {
}
