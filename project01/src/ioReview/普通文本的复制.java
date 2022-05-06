package ioReview;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @date 2021/4/10 -16:58
 * 使用字符流
 * 一边读，一边写
 */
public class 普通文本的复制 {
    public static void main(String[] args) {
//        创建文件输出输入流对象
        FileReader fr = null;
        FileWriter out = null;
        try {
            fr = new FileReader("info.TXT");
            out = new FileWriter("infoCost.TXT", true);
//            创建字符数组
            char[] c = new char[10];
            int readCount = 0;
            while ((readCount = fr.read(c)) != -1) {
                out.write(c, 0, readCount);
                System.out.println(new String(c));
                System.out.println("文件复制完毕");
            }


//            刷新输出流
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
//            关闭流
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
