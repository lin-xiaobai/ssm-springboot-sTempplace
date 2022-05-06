package com.spring5.BeanLift;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;

/**
 * @date 2021/7/15 -18:58
 * bean的后置处理器（在初始化之前和之后执行）[需要在spring配置文件中配置]，bean生命周期有七步
 * 需要实现接口BeanPostProcessor： 说明这个是一个后置处理器
 * 并且实行接口中的两个方法（ ） 由于方法前面是使用 default修饰
 * <p>
 * default修饰的方法可以不用实现
 * <p>
 * <p>
 * 1.通过无参构造方法创建bean实例
 * 2.为bean的属性设置值和调用其他bean引用（调用set方法）
 * 3.把bean实例传递bean后置处理器的方法postProcessBeforeInitialization
 * <p>
 * 4.调用bean的初始化的方法（需要进行配置初始化的方法
 * <p>
 * 5.把bean实例传递bean后置处理器的方法postProcessAfterInitialization
 * <p>
 * 6.bean可以使用（对象获取到）
 * 7.当容器关闭时候，调用bean的销毁的方法（需要进行配置销毁的方法）
 */
public class afterChuliqi implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("3.把bean实例传递bean后置处理器的方法 在初始化之前执行的方法");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("4.把bean实例传递bean后置处理器的方法 在初始化之前执行的方法");
        return bean;
    }
}
