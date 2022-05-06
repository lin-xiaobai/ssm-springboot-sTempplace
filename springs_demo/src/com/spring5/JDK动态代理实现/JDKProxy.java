package com.spring5.JDK动态代理实现;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @date 2021/7/19 -22:39
 * <p>
 * AOP(JDK动态代理）：主要的目标是在不改变原有代码的前提下增强原有方法
 * 1.使用 JDK动态代理，使用Proxy类里面的方法创建  代理对象
 */
//（3）使用Proxy类创建接口代理对象
public class JDKProxy {
    public static void main(String[] args) {
//        创建接口实现类代理对象
//        newProxyInstance方法中的
//        第一个参数为：类加载器  JDKProxy.class.getClassLoader():获取类加载器

//        第二个参数为：增强方法所在的类，这个类实现的接口，支持多个接口
//        第二个参数为 一个class类型的接口数组

//        第三个参数：实现这个接口InvocationHandler，创建代理对象，写增强的部分
//        因为第三个参数为InvocationHandler接口，
//        要么编写一个匿名内部类，
//        要么写一个类继承 InvocationHandler接口，然后在类中new InvocationHandler()方法

//        定义一个class的接口数组
        Class[] interfaces = {UserDao.class};
//        第三个参数为 编写一个匿名内部类
//        Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                return null;
//            }
//        });

//      第三个参数为 一个类继承 InvocationHandler接口，然后在类中new InvocationHandler()方法
        UserDaoImpl userDao = new UserDaoImpl();
//        这个方法的返回的是 代理对象(object对象）
//        强转为UserDao接口 强转的类型必须是接口类型，写强转成class类型会出错
        UserDao userdao = (UserDao) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new UserDaoProxy(userDao));
//      检验代理对象 add方法
//       int result= userdao.add(1,2);
//       String result= userdao.update("120");
        userdao.dele();
//        System.out.println("结果为"+result);
    }
}
//创建代理对象代码 :实现InvocationHandler接口

//增加的功能：在userdao类中的add方法
//执行前添加 一个操作（输出一串字符）
//执行后添加 一个操作（输出一串字符）
class UserDaoProxy implements InvocationHandler {

//    1.把创建的是谁的代理对象，把谁传递过来 。
//例如：这个案例是对userdaoImol类进行增强操作，所以代理对象就是 userdaoImol

//    如何 -->传递代理对象
//    方式一：通过有参数构造传递代理对象

    //    创建一个万能对象接收代理对象
    private Object obj;

    public UserDaoProxy(Object obj) {
        this.obj = obj;
    }


//    在invoke方法里面写的是 增强的逻辑

    //增强的逻辑要求：
//增加的功能：在userdao类中的add方法
//执行前添加 一个操作（输出一串字符）
//执行后添加 一个操作（输出一串字符）
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

//        方法之前输出内容
//        method.getName()  获取方法名
//        Arrays.toString(args)：遍历 args数组
        System.out.println("方法之前执行..." + method.getName() + ":传递的参数..." + Arrays.toString(args));

//       被增强的方法执行
//        第一个参数是代理对象
//        第二个参数是参数

//        判断代理对象的是哪个方法
        Object res = null;
//       这句话 表示的是当前的方法
        if ("add".equals(method.getName())) {
            res = method.invoke(obj, args);
        } else if ("update".equals(method.getName())) {
            res = method.invoke(obj, args);
        } else if ("dele".equals(method.getName())) {
            res = method.invoke(obj);
        } else {
            System.out.println("404.。.");
        }

//        方法之后
        System.out.println("方法执行之后...." + obj);

        return res;


    }
}