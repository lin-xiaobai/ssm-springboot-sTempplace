package io流;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @date 2021/3/24 -16:20
 * 原理：
 * 先使用输入流inputstream写到内存中
 * 再使用输出流outinputstream写到硬盘中
 */
public class 字节流复制文件 {
    public static void main(String[] args) throws Exception {
//        创建一个输入流对象，读取文件（实例化）
        FileInputStream fis = new FileInputStream("E:\\123.TXT");
        //        创建一个输出流写入文件
        FileOutputStream fos = new FileOutputStream("E:\\789.TXT");
//        定义一个byte数组保存数据,长度为100
        byte[] b = new byte[100];
//        定义一个读取字节的个数的变量
        int count = 0;
//        当读取的数据完毕后会返回一个-1的值，
//        使用循环
//        边读边写
        while ((count = fis.read(b)) != -1) {
            //        写入数据到文件
            fos.write(b, 0, count);
        }
        fis.close();
        fos.close();
//        关闭流
        System.out.println("执行完毕");

    }
}
