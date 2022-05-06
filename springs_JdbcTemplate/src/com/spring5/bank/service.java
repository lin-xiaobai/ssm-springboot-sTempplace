package com.spring5.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @date 2021/7/24 -12:08
 * <p>
 * * 事务管理
 * * 在service类上或者方法上添加事务注解 ：@Transactional注解
 * * 在类上表示所有的方法都可以添加事务
 * * 在方法上表示为这个方法添加注解
 * *
 */

@Service//注解 创建对象
@Transactional//创建事务管理器注解对象
public class service {
    //    这个注解表示属性可以为空，如果是在方法上的，表示方法的返回值可以为空
    @Nullable//
    private String name;

    //    注入dao
    @Autowired
    private dao dao;

    public void count(int money) {
        dao.detoryMoney(money);
//int num=10/0;
        dao.AddMoney(money);
    }
}
