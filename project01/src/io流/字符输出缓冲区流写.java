package io流;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * @date 2021/3/24 -19:18
 */
public class 字符输出缓冲区流写 {
    public static void main(String[] args) throws Exception {
        FileWriter fw = new FileWriter("e:\\wca.TXT");
        BufferedWriter bw = new BufferedWriter(fw);
        for (int i = 0; i < 10; i++) {
            bw.write("您好啊啊啊");
            bw.newLine();//相当于\n\r
        }
        fw.flush();
        bw.close();
        System.out.println("缓冲区写入成功");
    }

}
