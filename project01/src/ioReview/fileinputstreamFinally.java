package ioReview;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @date 2021/4/10 -14:47
 */
public class fileinputstreamFinally {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("789.TXT");
//            定义一个数组，长度4
            byte[] bytes = new byte[4];
//            定义一个文件读取的个数
            int readCount = 0;
            while ((readCount = fis.read(bytes)) != -1) {
//                将byte数组转换成string类型
                System.out.println(new String(bytes, 0, readCount));
            }
            System.out.println(readCount);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
