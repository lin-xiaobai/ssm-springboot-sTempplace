package io流;

import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @date 2021/3/24 -20:26
 */
public class 字符与字节读 {
    public static void main(String[] args) throws Exception {
        FileInputStream fs = new FileInputStream("e:\\789.TXT");
        InputStreamReader isr = new InputStreamReader(fs, "utf-8");
        char[] b = new char[1024];
        int count = 0;
        while ((count = isr.read(b)) != -1) {
            System.out.println(new String(b, 0, count));
        }
        isr.close();
        System.out.println("执行成功");

    }

}
