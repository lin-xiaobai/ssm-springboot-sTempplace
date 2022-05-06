package com.spring5.annotation.注入属性;

import org.springframework.stereotype.Service;

/**
 * @date 2021/7/19 -16:37
 * @Service 添加创建对象注解
 */
//注释的id
@Service(value = "userDao")
public class dao {
    public void testDao() {
        System.out.println("dao.....");
    }
}
