package 注解Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @date 2021/4/18 -14:15
 */
//表示这个注解只能在类上
@Target(ElementType.TYPE)
//表示这个注解可以被反射机制读取
@Retention(RetentionPolicy.RUNTIME)
public @interface IDname {

}
