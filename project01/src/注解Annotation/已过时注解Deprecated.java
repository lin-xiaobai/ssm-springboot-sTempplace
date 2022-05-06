package 注解Annotation;

/**
 * @date 2021/4/18 -11:24
 * @Deprecated这个注解标注的元素已过时。 这个注解主要是向其它程序员传达一个信息，告知已过时，有更好的方案
 */
public class 已过时注解Deprecated {
    @Deprecated
    public void m1() {
        try {
            System.out.println(Class.forName("注解Annotation.已过时注解Deprecated").getSimpleName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class m1 {
    public static void main(String[] args) {
        new 已过时注解Deprecated().m1();
    }
}
