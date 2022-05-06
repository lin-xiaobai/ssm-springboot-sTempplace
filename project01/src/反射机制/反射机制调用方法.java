package 反射机制;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @date 2021/4/17 -13:57
 */
public class 反射机制调用方法 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

//            四要素
//
//        1.方法chiek
//        2.对象 s
//        3.参数"aa","bb"
//        4.返回值value
        Student s = new Student();
        boolean value = s.chiek("aa", "bb");
        System.out.println(value);


//        反射机制调用一个对象的方法
        //        获取类,使用反射机制调用一个对象的方法
        Class studentClass = Class.forName("反射机制.Student");
//        创建对象，通过调用newInstance方法，底层调用了无参构造方法
        Object obj = studentClass.newInstance();
//        获取方法，
        Method methods = studentClass.getDeclaredMethod("chiek", String.class, String.class);

//        调用方法：4要素
//        四要素：
//        methods方法
//        obj对象
//        ab","pwd"实参
//        objectValue返回值
        Object objectValue = methods.invoke(obj, "ab", "pwd");
        System.out.println(objectValue);

        Method method = studentClass.getDeclaredMethod("sun", int.class, int.class);

        Object intValue = method.invoke(obj, 12, 13);
        System.out.println(intValue);


    }
}
