package 注解Annotation;

import java.lang.reflect.Field;

/**
 * @date 2021/4/18 -14:24
 */
public class test01 {
    public static void main(String[] args) throws Exception {
//        获取类
        Class c = Class.forName("注解Annotation.test");
//        Annotation annotation=c.getAnnotation(IDname.class);
//       判断类中是否有这个id注解
        if (c.isAnnotationPresent(IDname.class)) {
//            需求：如果一个类上面有@注解的时候，该类汇总必须有int类型的id属性
//            如果没有int类型的id属性则报异常
//            获取类的所有属性
            Field[] fields = c.getDeclaredFields();
            boolean b = false;
            for (Field field : fields) {
//                        判断属性名和属性类型
                if ("id".equals(field.getName()) && "int".equals(field.getType().getSimpleName())) {
                    b = true;
                    break;
                }
                System.out.println(field.getType().getSimpleName() + " " + field.getName());
            }
            if (!b) {
                MyException my = new MyException("必须有一个int类型");
                my.printStackTrace();
            }
        }

    }
}
