package com.spring5.annotation.注入属性;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @date 2021/7/19 -18:19
 * 完全注解开发：不用xml配置文件
 * （1）创建配置类，替代xml配置文件
 */
@Configuration//作为配置类。替代xml配置文件
//扫描  后面写要扫描的包名
@ComponentScan(basePackages = {"com.spring5.annotation.注入属性"})
public class config {
}
