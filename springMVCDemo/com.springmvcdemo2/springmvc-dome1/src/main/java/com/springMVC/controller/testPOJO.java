package com.springMVC.controller;

import com.springMVC.Bean.Userbean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @date 2021/9/7 -21:00
 *
 */
@Controller
public class testPOJO {
//    设置test_pojo的访问路径为testpojo
    @RequestMapping("/testpojo")
    public String testpojo(){
        return "test_POJO";
    }
//    测试在控制器方法的形参位置设置一个实体类类型的形参
    @RequestMapping("/testbean")
    public String testbean(Userbean user){
        System.out.println(user);
        return "success";
    }

}
