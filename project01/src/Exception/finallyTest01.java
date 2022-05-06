package Exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @date 2021/3/22 -19:08
 * finally
 * 必须和try语句一起，即使try语句块中出现异常，但是finally也是一定会执行的
 * <p>
 * 如果在try语句块中在那段代码中发生了异常，
 * try语句块的那段代码信息是执行不了的}
 */
public class finallyTest01 {
    public static void main(String[] args) {
        //声明位置放到try外面。这样在finally中才能使用。
        FileInputStream fis = null;
        try {
//           创建输入流对象，
//            需要关闭流的
            fis = new FileInputStream("E:\\123.TXT");
//            这段代码会发生空指针异常
            String s = null;
            s.toString();
            System.out.println("如果上面的代码有异常的话是执行不到下面语句的");
        } catch (FileNotFoundException e) {
//            打印输出简单的描述异常信息
            System.out.println(e.getMessage());
//            打印异常堆栈追踪信息
            e.printStackTrace();
        } catch (NullPointerException n) {
            //打印输出异常堆栈追踪信息
            n.printStackTrace();
            System.out.println("jhe");
        } finally {
//            对上面流的关闭，放在这里比较保险
//            因为finally一定会执行，即使try中出现异常
//            防止上面创建的流是空的
            if (fis != null) {
                try {
//                    关闭流
                    fis.close();
                } catch (IOException e) {
//                    打印输出堆栈异常追踪信息
                    e.printStackTrace();
                }
            }

        }


    }
}
