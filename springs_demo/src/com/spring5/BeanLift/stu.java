package com.spring5.BeanLift;

/**
 * @date 2021/7/15 -18:04
 * bean的生命周期
 * 1.通过无参构造方法创建bean实例
 * 2.为bean的属性设置值和调用其他bean引用（调用set方法）
 * 3.调用bean的初始化的方法（需要进行配置初始化的方法
 * 4.bean可以使用（对象获取到）
 * 5.当容器关闭时候，调用bean的销毁的方法（需要进行配置销毁的方法）
 */
public class stu {
    private String name;

    public stu() {
        System.out.println("bean的生命周期 1.通过无参构造方法创建bean实例");
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("bean的生命周期 2.为bean的属性设置值和调用其他bean引用（调用set方法）");
    }

    //    定义一个bean的初始化的方法
    public void initMethod() {
        System.out.println("bean的生命周期 3.调用bean的初始化的方法（需要进行配置初始化的方法");
    }

    //    定义bean的销毁的方法
    public void destoryMthod() {
        System.out.println("5.当容器关闭时候，调用bean的销毁的方法（需要进行配置销毁的方法）");
    }


}
