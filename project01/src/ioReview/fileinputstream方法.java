package ioReview;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @date 2021/4/10 -14:57
 * 常用方法：
 * int available():返回流当中剩余的没有读到的字节数量（
 * （可计算文件的字节数量）
 * long skip（long  n):跳过几个字节
 */
public class fileinputstream方法 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("789.TXT");
//            可以在这里查询文件的字节数量
            System.out.println("文件的总字节：" + fis.available());
//            读取1个字节
            int count = fis.read();
            System.out.println("当前剩余的字节没有读取" + fis.available());
//            跳过几个字节不等
            fis.skip(3);

            System.out.println("跳过3个字节后字节：" + fis.read());
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
