package io流;

import java.io.FileReader;

/**
 * @date 2021/3/24 -18:35
 */
public class 字符输入读流 {
    public static void main(String[] args) throws Exception {
//        创建文件字符输入流
        FileReader fr = new FileReader("e:\\789.TXT");
//        读取文件
//       1.单个字符读取
//        int data=0;
//        while ((data=fr.read())!=-1){
////            强转为char类型
//            System.out.println((char) data);
//        }
//        2。多个字符一起读
//        定义一个数组（缓冲区）
        char[] b = new char[1024];
        int data = 0;
        while ((data = fr.read(b)) != -1) {
//            创建一个字符串对象
            System.out.println(new String(b, 0, data));
        }
//        关闭流
        fr.close();
    }
}
