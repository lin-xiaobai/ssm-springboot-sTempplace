package Exception;

/**
 * @date 2021/3/21 -21:28
 */
public class test01 {
    public static void main(String[] args) {
        int a = 10;
        int b = 0;
//        JVM执行到这里的时候，会new异常对象
//        System.out.println(a/b);


        ArithmeticException d = new ArithmeticException("除数不能为0");
        System.out.println(d);
    }
}
