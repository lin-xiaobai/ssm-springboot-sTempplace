package com.spring5.JDK动态代理实现;

/**
 * @date 2021/7/19 -22:36
 */
//创建接口，定义方法
public interface UserDao {
    public int add(int a, int b);

    public String update(String id);

    public void dele();
}
