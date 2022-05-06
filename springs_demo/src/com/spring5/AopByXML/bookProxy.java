package com.spring5.AopByXML;

/**
 * @date 2021/7/21 -0:02
 * AOP操作（AspectJ配置文件）
 * 1.创建两个类 ，增强类和被增强类，创建方法
 * <p>
 * 2.在spring配置文件中创建两个类对象
 */
public class bookProxy {
    public void before() {
        System.out.println("before.....");
    }
}
