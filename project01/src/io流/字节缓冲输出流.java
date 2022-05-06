package io流;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

/**
 * @date 2021/3/24 -17:14
 */
public class 字节缓冲输出流 {
    public static void main(String[] args) throws Exception {
//        创建字节输出流（实例化）
        FileOutputStream fos = new FileOutputStream("e:\\910.TXT");
//        创建字节缓冲输出流
        BufferedOutputStream bos = new BufferedOutputStream(fos);
//        循环10次
        for (int i = 0; i < 10; i++) {
//            将字符串变成字符
            bos.write("hellowork\r\n".getBytes());
//            刷新缓冲区
            bos.flush();
        }
//        关闭流(如果上面没有使用flush方法，在这里关闭流的时候，会调用flush方法）
        bos.close();
    }
}
