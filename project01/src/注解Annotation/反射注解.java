package 注解Annotation;

/**
 * @date 2021/4/18 -12:36
 */
public class 反射注解 {
    public static void main(String[] args) throws Exception {
//        获取类
        Class name = Class.forName("注解Annotation.使用自定义注解");
//           判断类中是否有那个注解(传参是一个字节码文件
        System.out.println(name.isAnnotationPresent(自定义注解.class));
//            获取注解中的属性值
        if (name.isAnnotationPresent(自定义注解.class)) {
//                返回是一个Annotation
//                强转
//                获取注解上的对象
            自定义注解 z1 = (自定义注解) name.getAnnotation(自定义注解.class);
//                获取注解上的对象的值
            System.out.println("类上的注解对象" + z1.value());
        }

    }
}
