package com.spring5.JDK动态代理实现;

/**
 * @date 2021/7/19 -22:37
 * AOP(JDK动态代理）
 */
//创建接口实现类，实现方法
public class UserDaoImpl implements UserDao {
    @Override
    public int add(int a, int b) {
        System.out.println("add方法执行");
        return a + b;
    }

    @Override
    public String update(String id) {
        System.out.println("update方法执行。。。。");
        return id + "=" + id;
    }

    @Override
    public void dele() {
        System.out.println("没有返回值的");
    }

}
