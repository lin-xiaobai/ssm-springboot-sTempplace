package 注解Annotation;

/**
 * @date 2021/4/18 -11:36
 */
@自定义注解
public class 使用自定义注解 {
    //    报错的原因：自定义注解只能注解类和方法
//    @注解的属性类型()
    int a;

    //    报错的原因：没有指定属性名和属性值
//
//    @MyAnnotation(name="张三",age="000")
    @MyAnnotation(name = "张三")
    public void name() {
    }

    //    可以省略属性的原因是：属性名为value并且只有一个属性
//    当属性名为value时和只有一个属性的时候，可以省略属性名，直接写属性值
//    @MyAnnotation2("shandog")
    @MyAnnotation2(111)
    public void doOther() {

    }

    //    报错的因为是必须给属性赋值
//    属性为数组并且数组中有多个元素
    @注解的属性类型(e = {enumTest.WINDOW, enumTest.SUM, enumTest.SUMMER}, b = {2, 4, 6})
    public void name1() {
    }

    //    属性为数组并且数组中有1个元素，可以省略大括号
    @注解的属性类型(e = enumTest.SUM, b = 1)
    public void name2() {

    }
}
