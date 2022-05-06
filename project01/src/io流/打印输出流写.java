package io流;

import java.io.PrintWriter;

/**
 * @date 2021/3/24 -20:04
 */
public class 打印输出流写 {
    public static void main(String[] args) throws Exception {
        PrintWriter pw = new PrintWriter("e:\\wca.TXT");
        pw.println('a');
        pw.println(64);
        pw.println(true);
        pw.flush();
        pw.close();
        System.out.println("打印成功");
    }
}
