package ioReview;

import java.io.*;

/**
 * @date 2021/4/10 -18:04
 */
public class BufferedWrite测试 {
    public static void main(String[] args) throws IOException {
//        创建带有缓冲区的字符输出流
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("ooo.TXT", true)));
        for (int i = 0; i < 10; i++) {
            out.write("您好+\n");
        }
        out.flush();
        out.close();
    }
}
