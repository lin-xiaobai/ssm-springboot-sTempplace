package io流;

import java.io.FileOutputStream;

/**
 * @date 2021/3/24 -16:06
 * 文件字节输出流
 * fileoutputstream
 * 运行一次添加一次内容
 */
public class 输出流 {
    public static void main(String[] args) throws Exception {
//        创建文件字节输出流对象
//        FileOutputStream fos=new FileOutputStream("e:\\345.TXT");
//        追加内容到文件中，
        FileOutputStream fos = new FileOutputStream("e:\\345.TXT", true);
//        写入文件
//        使用输出流的其中一个方法：一个一个字节慢慢添加
//        参数为byte，整数类型会自动转换成字节类型
//        fos.write(97);
//        fos.write('a');
//        fos.write('4');
//        使用参数为数组的方法
//        定义一个string类型
        String s = "nihao";
//        写入文件
//        getBytes()这个方法可以将string中的内容转换为byte数组
        fos.write(s.getBytes());
//        关闭流
        fos.close();
        System.out.println("执行结束");
    }
}
