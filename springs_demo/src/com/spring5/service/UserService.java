package com.spring5.service;

import com.spring5.dao.IUserDao;
import com.spring5.dao.UserDaoImpl;
import org.junit.Test;

/**
 * @date 2021/7/8 -19:11
 * 要求调用userdao里面的update方法
 * 传统方法：实例化对象，然后对象调用方法
 * <p>
 * 外部bean
 * 测试方法：
 * （1）创建两个类service类和dao类
 * （2）在service调用dao里面的方法
 * （3）在spring配置文件中进行配置
 * <p>
 * 利用set方法进行注入对象属性（spring配置文件在）
 */
public class UserService {
    //    创建UserDao类型属性，生成set方法
//   定义私密接口
    private IUserDao userDao;

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    public void add() {
        System.out.println("service add.......");
//        在方法里面调用上面的定义的属性的方法
        userDao.update();
////    原始方式：创建userdao对象，然后调用方法
//        IUserDao userDao=new UserDaoImpl();
//        userDao.update();
    }

}
