package 反射机制;

import java.lang.reflect.Field;

/**
 * @date 2021/4/16 -20:15
 */
public class 通过反射机制获取属性值 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        Student S = new Student();
        System.out.println(S.no = 1);

        //        使用反射机制访问一个对象的属性
//        获取类
        Class className = Class.forName("反射机制.Student");
//        obj就是student对象。（底层调用了无参构造方法）
        Object obj = className.newInstance();
//        获取属性的值(根据属性名来获取field
        Field field = className.getDeclaredField("no");

//        给obj对象（studnet对象）的no属性赋值
        field.set(obj, 1111);
//        读取属性的值
        System.out.println(field.get(obj));

//        访问私自的属性
        Field fieldName = className.getDeclaredField("name");
//        打破封装(缺点：打破封装）
//        设置完之后，在外部也是可以访问private
        fieldName.setAccessible(true);
        fieldName.set(obj, "张三");
//        获取name属性的值
        System.out.println(fieldName.get(obj));
    }
}
