package 反射机制;

/**
 * @date 2021/4/16 -20:41
 * 可变长度参数
 * int....args这就是可变长度参数
 * 语法是：类型...（注意：一定是三个点）
 * 1.可变长度参数要求的参数个数为0---n个。
 * 2.可变长度参数在参数列表中必须在最后一个位置上，而且可变长度参数只能有1个。
 * 3.可变长度参数可以当做一个数组来看待。
 */
public class 可变长度参数 {
    public static void main(String[] args) {
        m1();
//            传入一个数组
        m2(1, 2, 3, 4, 5, 6);
        m3(2, "s", "a", "s");

    }

    public static void m1(int... agrs) {
        System.out.println("m");
    }

    public static void m2(int... args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
    }

    public static void m3(int num, String... args) {
        System.out.println(num + 20);
        for (String n : args) {
            System.out.println(n);
        }
    }
}
