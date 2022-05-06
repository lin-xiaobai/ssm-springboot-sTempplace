package io流;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * @date 2021/3/24 -20:13
 * 电脑保存是字节
 * Java保持是字符
 */
public class 字符与字节转换流 {
    public static void main(String[] args) throws Exception {
//        字符转换为字节流（byte-->char)
        FileOutputStream fs = new FileOutputStream("E:\\info.TXT");
        OutputStreamWriter osw = new OutputStreamWriter(fs, "utf-8");
        for (int i = 0; i < 10; i++) {
            osw.write("我爱\r\n");
            osw.flush();
        }
//        关闭流
        osw.close();
        System.out.println("success");
    }
}
