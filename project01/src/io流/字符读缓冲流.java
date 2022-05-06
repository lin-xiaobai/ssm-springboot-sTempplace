package io流;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @date 2021/3/24 -19:11
 */
public class 字符读缓冲流 {
    public static void main(String[] args) throws Exception {
//        创建文件字符（读）输入流写
        FileReader fr = new FileReader("E:\\789.TXT");
//        字符输入缓冲区：参数为字符点
        BufferedReader br = new BufferedReader(fr);
//        这个是字符类型
        char[] b = new char[1024];
        int count = 0;
        while ((count = br.read(b)) != -1) {
//            将字符类型转换成字符串类型
            System.out.println(new String(b, 0, count));
        }
//        关闭流
        br.close();
    }
}
