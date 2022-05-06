package 静态内部类;

/**
 * @date 2021/4/8 -20:02
 */
public class test {
    //    声明一个静态内部类
    private static class ma {
        //        静态方法
        public static void m1() {
            System.out.println("静态内部类的静态方法m1");
        }

        //    实例方法
        public void m2() {
            System.out.println("静态内部类的实例方法m2");
        }
    }

    public static void main(String[] args) {
//        调用静态内部类的静态方法m1
        test.ma.m1();
//        调用静态内部类的实例方法m2
//        创建对象
        test.ma i = new test.ma();
        i.m2();
    }
}
