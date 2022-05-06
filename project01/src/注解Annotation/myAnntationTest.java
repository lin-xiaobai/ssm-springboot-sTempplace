package 注解Annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @date 2021/4/18 -12:54
 */
//这个注释能被反射机制读取到
@Retention(RetentionPolicy.RUNTIME)
public @interface myAnntationTest {
    String name();

    int id();
}
