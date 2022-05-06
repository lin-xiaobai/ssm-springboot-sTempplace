package com.example.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;

/**
 * @date 2021/11/27 -17:26
 * 自定义表单中的input标签中发送的put和delete请求方式下默认使用的 name为_method的属性值
 */
//proxyBeanMethods配置类是用来指定@Bean注解标注的方法是否使用代理，默认使用代理 true
//标注这个是一个配置类 取消代理模式
@Configuration(proxyBeanMethods = false)
public class WebConfig {
    @Bean//将该组件添加到IOC容器中
//   自定义一个HiddenHttpMethodFilter拦截器（主要是设置put和delete请求）
    public HiddenHttpMethodFilter hiddenHttpMethodFilter(){
        HiddenHttpMethodFilter methodFilter = new HiddenHttpMethodFilter();
//        将_method修改为_m
        methodFilter.setMethodParam("_m");
        return methodFilter;
    }

}
