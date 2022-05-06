package io流;

import java.io.FileWriter;

/**
 * @date 2021/3/24 -18:55
 */
public class 字符输出流 {
    public static void main(String[] args) throws Exception {
//        创建文件输出(写）流
        FileWriter fw = new FileWriter("e:\\hell.TXT");
        String name = "您好哈";
        for (int i = 0; i < 10; i++) {
            fw.write(name + "\r\n");
        }
        fw.close();


    }
}
