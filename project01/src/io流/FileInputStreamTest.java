package io流;

import java.io.*;

/**
 * @date 2021/3/24 -15:53
 * 输入流
 * 使用字节流读数据
 * 当数据读取完毕后会输sout                                出-1；
 */
public class FileInputStreamTest {
    public static void main(String[] args) throws Exception {
//        1.创建fileinputstream对象，并且指定文件
        FileInputStream fis = new FileInputStream("e:\\123.TXT");
//        读取文件
//        创建数组保存数据
        byte[] b = new byte[10];
//        counts实际读取的个数
        int count = 0;
        while ((count = fis.read(b)) != -1) {
            System.out.println(new String(b, 0, count));
        }
//        关闭流
        fis.close();

        System.out.println();
        System.out.println("执行完毕");
    }
}
