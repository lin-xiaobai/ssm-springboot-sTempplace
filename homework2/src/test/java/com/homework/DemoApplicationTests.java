package com.homework;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
@Slf4j//记录日志
@SpringBootTest
class DemoApplicationTests {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Test
    void contextLoads() {
        System.out.println(jdbcTemplate);
        List list = jdbcTemplate.queryForList("select * from stu");
        for (Object obj : list) {
            System.out.println(obj);
        }
//        查询多少个人
        Long aLong = jdbcTemplate.queryForObject("select count(*) from stu", Long.class);
        log.info("记录总数{}",aLong);
    }

}
