package 代理类.动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @date 2021/7/20 -14:46
 * 动态代理类：
 * <p>
 * 要想实现动态代理，需要解决的问题：
 * 问题一：如何根据加载到内存中的被代理类，动态的创建一个代理类以及其对象
 * 问题二：当通过代理类的对象调用方法时，如何动态的去调用被代理类中的同名方法
 */

//定义一个接口
interface Human {
    public String name();

    public void eat(String food);
}

//在不动原来的代码上，添加两个输出功能
class Addmethod {
    public void method1() {
        System.out.println("-----方法1执行");
    }

    public void method2() {
        System.out.println("-----方法2执行");
    }
}


//继承接口  被代理类
class superHuman implements Human {

    @Override
    public String name() {
        return "myname is Superman";
    }

    @Override
    public void eat(String food) {
        System.out.println("eat" + food);
    }
}

//代理类
class ProxyFactory {
//

    //    定义一个方法获取代理类对象 obj是被代理对象
//    第一个参数是一个类加载器，哪个被代理对象就调用哪个类加载器
//    第二个参数是接口数组
    public static Object getProxyInstance(Object obj) {
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new myInvocationHandler(obj));
    }
}

//定义一个实现类去实现InvocationHandler()接口
class myInvocationHandler implements InvocationHandler {
    Addmethod add = new Addmethod();

    //        需要使用被代理类的对象进行赋值
    private Object obj;

    //    赋值方式：可以通过有参构造 或者定义一个方法
    public myInvocationHandler(Object obj) {
        this.obj = obj;
    }

//    public void bind(Object obj){this.obj=obj;}

    //当通过代理类的对象，调用方法a时，就会自动的调用如下的方法：invoke()
//    将被代理类要执行的方法a的功能就声明在invoke中
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {

//        添加输出功能
        add.method1();

//        method:即为代理类对象调用的方法，此方法也就作为了被代理类对象要调用的方法
//        obj：被代理类的对象

        Object returnValu = method.invoke(obj, objects);
//      上述方法的返回值就作为当前类中的invoke()的返回值

        add.method2();
        return returnValu;
    }
}

public class ActiveProxyTest {
    public static void main(String[] args) {
//        被代理类
        superHuman superHuman = new superHuman();
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superHuman);
        System.out.println(proxyInstance.name());
        proxyInstance.eat("是");

    }


}
