package com.spring5.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @date 2021/7/24 -12:08
 */
//创建对象 注解模式
@Repository
public class daoImpl implements dao {
    //        注入jdbcTemplate对象
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void AddMoney(int moneys) {
        String sql = "update bank set money=money - ? where user=?";
        int count = jdbcTemplate.update(sql, moneys, "zs");
        System.out.println(count);
    }

    @Override
    public void detoryMoney(int moneys) {
        String sql = "update bank set money=money+ ? where user=?";
        int count = jdbcTemplate.update(sql, moneys, "xm");
        System.out.println(count);
    }
}
