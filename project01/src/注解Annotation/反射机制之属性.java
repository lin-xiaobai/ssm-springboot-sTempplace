package 注解Annotation;

import java.lang.annotation.Annotation;

/**
 * @date 2021/4/18 -12:56
 * 反射机制之属性 获取多个注释上的属性值
 */
//获取注释上的信息
public class 反射机制之属性 {
    public static void main(String[] args) throws Exception {
//        获取类
        Class c = Class.forName("注解Annotation.注解作用");
//        判断类中是否含有这个注释
        System.out.println(c.isAnnotationPresent(myAnntationTest.class));

//        当有一个注释时获取属性
        if (c.isAnnotationPresent(myAnntationTest.class)) {
//            获取对象
            Annotation annotation = c.getAnnotation(myAnntationTest.class);
//            强制为目标对象
            myAnntationTest mat = (myAnntationTest) annotation;
//            获取注解上的信息
            System.out.println(mat.id());
            System.out.println(mat.name());

        }
    }
}

