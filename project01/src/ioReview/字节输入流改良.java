package ioReview;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @date 2021/4/10 -14:17
 * <p>
 * int read（byte[] b)
 * 一次最多读取b.length字节。
 * 减少硬盘和内存的交互，提高程序的执行效率
 * 往byte[]数组当中读。
 */
public class 字节输入流改良 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
//            idea的默认目录是project的根目录
            fis = new FileInputStream("789.TXT");
//            准备一个4个长度的byte数组，一次只能读取到4个字节
            byte[] b = new byte[4];
//            这个方法返回值是：读取到的字节数量。（不是字节本身）

            int readCount = fis.read(b);
//            System.out.println(readCount);//第一次读到4个字节
//            结果是abcd
//            将字节数组转换成字符串
//            System.out.println(new String(b));
//            不应该全部都转换，应该是读取多少个字节，转换多少个
            System.out.println(new String(b, 0, readCount));

//            由于第一次读到abcd，还剩ef，但第二次读取的结果是efcd
//            二次读取的byte数组的元素会覆盖第一次读取的元素
            readCount = fis.read(b);//第二次读到4个字节
            System.out.println(readCount);//第二次读到2个字节
//            将字节数组转换成字符串:结果是efcd
//            System.out.println(new String(b));
//            不应该全部都转换，应该是读取多少个字节，转换多少个
//            传入的参数是：数组名，从第0下标，读取readcount个
            System.out.println(new String(b, 0, readCount));

            readCount = fis.read(b);//第三次读取，由于第一次和第二次已经把文件读取完了，所以第三次读取会返回一个-1
            System.out.println(readCount);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
