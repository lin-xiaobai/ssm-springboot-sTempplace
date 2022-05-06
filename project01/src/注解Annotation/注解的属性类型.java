package 注解Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @date 2021/4/18 -12:06
 * 注解的属性：
 * byte，short，int，float，double，Boolean，char，Class，枚举类型
 * 以及以上类型的数组
 */

//只允许该注解可以标注类、方法
@Target({ElementType.TYPE, ElementType.METHOD})
//希望这个注解可以被反射
@Retention(RetentionPolicy.RUNTIME)
public @interface 注解的属性类型 {
    int[] b();

    //    枚举数组类型
    enumTest[] e();


}
