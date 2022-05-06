package com.spring5.testSpring5;

import com.spring5.collectionType.collectionTypeBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @date 2021/7/9 -19:26
 * 测试xml注入集合属性
 * 值为基本数据类型和对象类型
 */
public class collectionBean {
    @Test
    public void testCollection() {
//        引入xml文件
        ApplicationContext context = new ClassPathXmlApplicationContext("collectionBean.xml");
//    获取配置文件中bean属性 ，返回值是一个对象属性
//        第一个参数为xml文件中的name属性，第二个是加入依赖，即字节码文件
        collectionTypeBean contextBean = context.getBean("cousers", collectionTypeBean.class);
//        调用方法
        contextBean.show();
    }
}
