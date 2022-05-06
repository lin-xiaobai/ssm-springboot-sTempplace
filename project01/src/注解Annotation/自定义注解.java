package 注解Annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @date 2021/4/18 -12:33
 */
//这个注解能被反射机制获取
@Retention(RetentionPolicy.RUNTIME)
public @interface 自定义注解 {
    String value() default "广东增城";
}
