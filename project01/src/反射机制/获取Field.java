package 反射机制;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @date 2021/4/16 -19:24
 */
public class 获取Field {
    public static void main(String[] args) throws ClassNotFoundException {
//        获取类
        Class StudentClass = Class.forName("反射机制.Student");
//        获取类中的所有的public修饰的Field
        Field[] fields = StudentClass.getFields();
//        测试数组中的个数
        System.out.println(fields.length);
//        取出field元素
        for (Field field : fields) {
            System.out.println(field.getName());
        }

//        取出所有的Field
        Field[] fields1 = StudentClass.getDeclaredFields();
        System.out.println(fields1.length);
        for (Field field : fields1) {
//            获取属性的修饰符
            int i = field.getModifiers();
            String stri = Modifier.toString(i);
            System.out.println(stri);
//            获取属性中的类型
            Class type = field.getType();
//            System.out.println(type.getName());
//            属性的简单名字
            System.out.println(type.getSimpleName());
//            获取属性名
            System.out.println(field.getName());
        }
    }
}
