package io流;

import java.io.FileReader;
import java.io.FileWriter;

/**
 * @date 2021/3/24 -19:05
 * 字节流只能复制文本，不能复制二进制文件
 */
public class 字节流复制文本 {
    public static void main(String[] args) throws Exception {
//        创建文件输入流和输出流（实例化）
        FileReader fr = new FileReader("e:\\789.TXT");
        FileWriter fw = new FileWriter("e:\\911.TXT");

//        边读边写
        int data = 0;
        while ((data = fr.read()) != -1) {
            fw.write(data);
            fw.flush();
        }
//        关闭流
        fr.close();
        fw.close();
        System.out.println("执行成果");
    }
}
