package com.spring5.FactoryBean;

import com.spring5.User;
import com.spring5.student;
import org.springframework.beans.factory.FactoryBean;

/**
 * @date 2021/7/14 -19:07
 * 将这个类定义成工厂bean，需要实现接口FactoryBean
 * 并且实现接口里面的方法，在实现的方法定义返回的bean类型
 */
public class myBean implements FactoryBean<student> {
    //    定义返回的bean类型
    @Override
    public student getObject() throws Exception {
//      创建对象
        student student = new student();
        student.setName("zs");
        return student;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
