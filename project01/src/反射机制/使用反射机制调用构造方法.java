package 反射机制;

import java.lang.reflect.Constructor;

/**
 * @date 2021/4/17 -23:34
 */
public class 使用反射机制调用构造方法 {
    public static void main(String[] args) throws Exception {
//        获取类
        Class userClass = Class.forName("反射机制.user");
//        获取对象,调用无参构造方法

        Object obj = userClass.newInstance();
        System.out.println(obj);
//        调用无参构造方法
        Constructor constructors = userClass.getDeclaredConstructor();
        Object o2 = constructors.newInstance();
        System.out.println(o2);
//        调用有参构造
        Constructor constructor = userClass.getDeclaredConstructor(int.class, String.class);
        Object o = constructor.newInstance(110, "zhangsan");
        System.out.println(o);
    }
}
