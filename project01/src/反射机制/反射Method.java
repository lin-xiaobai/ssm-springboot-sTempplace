package 反射机制;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @date 2021/4/16 -21:03
 */
public class 反射Method {
    public static void main(String[] args) throws ClassNotFoundException {
//        创建字符串拼接对象
        StringBuilder sb = new StringBuilder();
//        创建类
        Class method = Class.forName("反射机制.Student");
//        获取所有的方法
        Method[] m = method.getDeclaredMethods();
//        遍历方法
        for (Method method1 : m) {
//            获取方法的修饰符
            sb.append(Modifier.toString(method1.getModifiers()));
            sb.append(" ");
//            获取方法的返回值类型
            sb.append(method1.getReturnType());
            sb.append(" ");
//            获取方法名
            sb.append(method1.getName());
            sb.append("{");
//            获取方法的修饰符列表（一个方法的参数可能有多个）
            Class[] c1 = method1.getParameterTypes();
            for (Class c : c1) {
                sb.append(c.getSimpleName());

            }
            sb.append("}");
        }
        System.out.println(sb);
    }
}
