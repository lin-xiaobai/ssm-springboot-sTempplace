package io流;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

/**
 * @date 2021/3/24 -16:56
 * 使用字节缓冲流是（输入流）读取
 * 提高io使用率
 */
public class 缓冲字节流 {
    public static void main(String[] args) throws Exception {
//        创建输入流读取数据(实例化对象）
        FileInputStream fis = new FileInputStream("e:\\123.TXT");
//        创建缓冲区
        BufferedInputStream bis = new BufferedInputStream(fis);
//       读取数据：
//        如果使用fis则每次读取数据都得从硬盘上读取，效率低
//        如果使用bis则每次读取数据的时候直接在缓冲区读取，效率高
//        使用方法中的缓冲区
//        定义一个变量存储文件读取个数
//        int data=0;
//        while((data=bis.read())!=-1){
////            转换成字符
//            System.out.println((char)data);
//        }

//        使用自定义缓冲区
        byte[] b = new byte[100];
        int count = 0;
        while ((count = bis.read(b)) != -1) {
//            转换成字符串类型
//            创建一个字符串类型，
//            第一个参数为byte数组，第二个参数为从哪开始
//            第三个参数为数据个数
            System.out.print(new String(b, 0, count));
        }
//        关闭缓冲区的时候也会关闭输入流
        bis.close();
    }
}
