package 反射机制;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @date 2021/4/16 -21:18
 */
public class 反编译Method {
    public static void main(String[] args) throws ClassNotFoundException {
//        拼接字符串
        StringBuilder sb = new StringBuilder();
//        Class c=Class.forName("反射机制.Student");
        Class c = Class.forName("java.lang.String");

        sb.append(Modifier.toString(c.getModifiers()) + " class " + c.getSimpleName() + "\n");
//        获取所有的方法
        Method[] methods = c.getDeclaredMethods();
        for (Method method : methods) {
            sb.append("\t");
//            获取修饰符
            sb.append(Modifier.toString(method.getModifiers()));
            sb.append(" ");
            sb.append(method.getReturnType().getSimpleName());
            sb.append(" ");
            sb.append(method.getName());
            sb.append("{");
//            获取修饰符列表
            for (Class name : method.getParameterTypes()) {
                sb.append(name.getSimpleName());
            }
            sb.append("}");
            System.out.println(sb);
        }

    }
}
