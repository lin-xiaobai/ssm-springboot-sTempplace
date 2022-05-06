package com.spring5.extractBean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @date 2021/7/14 -18:22
 * 测试从spring5配置文件中提取list集合中的属性
 */
public class test {
    @Test
    public void testBook() {
        ApplicationContext context = new ClassPathXmlApplicationContext("extractList.xml");
        book book = context.getBean("book", book.class);
        System.out.println(book);
    }

}
