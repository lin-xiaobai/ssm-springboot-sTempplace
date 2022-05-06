package ioReview;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @date 2021/4/10 -16:49
 * 字符输出流写
 * 只能写普通文本
 */
public class fileWriter流 {
    public static void main(String[] args) {
//        创建文件输出流对象
        FileWriter fw = null;
        try {
            fw = new FileWriter("xxx.TXT", true);
            char[] c = new char[]{90, 80, 70, 60};
            fw.write(c);
            String s = "java";
            fw.write(s);
            fw.write("\n");
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
