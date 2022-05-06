package 反射机制;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

/**
 * @date 2021/4/17 -22:54
 */
public class 反射Constructor构造方法 {
    public static void main(String[] args) throws Exception {
//        创建拼接字符对象
        StringBuilder sb = new StringBuilder();
//        获取类
//        Class userClass =Class.forName("反射机制.user");
        Class userClass = Class.forName("java.lang.String");

        sb.append(Modifier.toString(userClass.getModifiers()));
        sb.append(" class ");
        sb.append(userClass.getSimpleName());
        sb.append("{\n");
        Constructor[] constructor = userClass.getConstructors();

        for (Constructor constructor1 : constructor) {
            sb.append("\t");
            sb.append(Modifier.toString(constructor1.getModifiers()) + " " + userClass.getSimpleName() + "(");
            Class[] pt = constructor1.getParameterTypes();
            for (Class c : pt) {

                sb.append(c.getSimpleName());
                sb.append(",");

            }
//            删除最后下标位置的字符
            if (pt.length > 0) sb.deleteCharAt(sb.length() - 1);

            sb.append(")");
            sb.append("\n");

        }

        System.out.println(sb);
    }
}
