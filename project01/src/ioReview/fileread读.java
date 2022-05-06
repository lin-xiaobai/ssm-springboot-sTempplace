package ioReview;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @date 2021/4/10 -16:29
 * 读取文本，比较方便，快捷
 * 字符流
 */
public class fileread读 {
    public static void main(String[] args) {
        FileReader fr = null;
        try {
            fr = new FileReader("kkk.TXT");
//            char[] c=new char[4];
//            往char数组中读
//            fr.read(c);
////            按照字符的方式读取
//            for (char c1:c){
//                System.out.println(c1);
//            }


////            定义一个数组
            char[] c = new char[4];
            int readCount = 0;
            while ((readCount = fr.read(c)) != -1) {
//                System.out.println(new String(c,0,readCount));
//                读取char数组
                for (char c1 : c) {
                    System.out.println(c1);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
