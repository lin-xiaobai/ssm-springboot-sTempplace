package 注解Annotation;

/**
 * @date 2021/4/18 -10:53
 * 关于JDK lang包下的Override注解
 * Override注解叫做标识性注解，给编译器做参考的。
 * <p>
 * Override注解只能注解方法。
 * Override注解这个注解是给编译器参考的，和运行阶段没有关系。
 * <p>
 * 凡是java的方法带有这个注解的，编译器都会进行编译检查，如果这个方法不是重写父类的方法，编译器会报错。
 * <p>
 * 编译器看到方法上有这个注解的时候，编译器会自动检查该方法是否重写了父类的方法。
 * 如果没有重写，报错。
 * 这个注解只是在编译阶段起作用，和运行期无关。
 */
@myAnntationTest(name = "zhangsan", id = 100)
public class 注解作用 {
    @Override
    public String toString() {
        return super.toString();
    }
}
