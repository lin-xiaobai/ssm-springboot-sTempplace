package Exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @date 2021/3/22 -18:43
 * 打印异常堆栈追踪信息从上往下看
 */
public class getMessage_printStackTrace_test01 {
    public static void main(String[] args) {
        try {
            m1();
        } catch (FileNotFoundException e) {
//            获取简单描述的异常信息
            String stg = e.getMessage();
            System.out.println(stg);
//            打印异常堆栈追踪信息
//            e.printStackTrace();
        }
//        下面代码会继续执行
        System.out.println("hello");
    }

    private static void m1() throws FileNotFoundException {
        m2();
    }

    private static void m2() throws FileNotFoundException {
        m3();
    }

    private static void m3() throws FileNotFoundException {
        new FileInputStream("E:\\1234.TXT");
    }
}
