package com.boot.controller;

import com.boot.bean.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @date 2021/11/1 -18:33
 */
@Slf4j//开启日志功能
//@Controller和@ResponseBody的结合体
@RestController//控制器方法，方法的返回值是字符串类型，而且不是跳转页面
public class HelloController {
//    自动注入car组件
    @Autowired
    Car car;
//    测试从配置文件通过@ConfigurationProperties+@Component获取Properties配置文件中键值对
//    结果是自动转成json格式的数据
    @RequestMapping("/car")
    public Car carname(){
        log.info("请求进来了.....");
        return car;
    }
    @RequestMapping("/hello")
    public String hello(){
        return "hello,springboot";
    }
}
