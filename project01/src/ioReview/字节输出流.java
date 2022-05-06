package ioReview;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @date 2021/4/10 -15:37
 */
public class 字节输出流 {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        try {
//            这种方式会直接清空原文件内容，然后重新写入
//            fos=new FileOutputStream("789.TXT");
//            以追加的方式在文件末尾写入，不会清空原文件内容
            fos = new FileOutputStream("789.TXT", true);
//            定义一个数组
            byte[] b = new byte[]{32, 97, 98, 99, 100, 32};
//            将byte数组内容全部写出
            fos.write(b);
//            将byte数组的元素全部写出
//            写完以后，一定要刷新
//            先将数组byte的一部分写出
            fos.write(b, 0, 3);//先写abc
//            将字符串写入
            String s = "我am man\r";
//            将字符串转换成byte
            byte[] b2 = s.getBytes();
            fos.write(b2);
            fos.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
