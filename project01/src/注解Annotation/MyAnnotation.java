package 注解Annotation;

/**
 * @date 2021/4/18 -11:42
 */
public @interface MyAnnotation {
    //    在注解中自定义属性
//    看着像方法，但实际上是属性name
    String name();

    //    指定默认值
    String age = "113";

    //    指定默认值
    String color() default "红色";

}
