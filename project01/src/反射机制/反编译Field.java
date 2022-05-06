package 反射机制;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @date 2021/4/16 -19:46
 */
public class 反编译Field {
    public static void main(String[] args) throws Exception {
//        创建这个为了拼接字符串
        StringBuilder s = new StringBuilder();
//        获取类
        Class myClass = Class.forName("java.lang.String");
        s.append(Modifier.toString(myClass.getModifiers()) + " class " + myClass.getSimpleName() + " { \n");

//        获取类中的属性
        Field[] fields = myClass.getDeclaredFields();
        for (Field field : fields) {
//            添加制表符
            s.append("\t");
            s.append(" ");
            s.append(Modifier.toString(field.getModifiers()));
            s.append(" ");
            s.append(field.getType().getSimpleName());
            s.append(" ");
            s.append(field.getName());
            s.append(";\n");
        }
        s.append("}");
        System.out.println(s);
    }
}
