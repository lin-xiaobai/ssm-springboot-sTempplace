package ioReview;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @date 2021/4/10 -16:12
 * 使用fileinputsteam+fileoutsteam完成文件拷贝
 * 拷贝的过程是一边读，一边写
 * 使用字节流拷贝文件的时候，文件类型随便，是万能的
 */
public class 文件拷贝 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("789.TXT");
            fos = new FileOutputStream("kkk.TXT", true);
//            定义一个数组进行读写操作
            byte[] b = new byte[4];
            int readCount = 0;
//            如果文件读完内容会返回一个-1
            while ((readCount = fis.read(b)) != -1) {
//               写入文件，参数：数组，下标，读取的个数
                fos.write(b, 0, readCount);
            }
//            刷新输出流
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
//            如果一起try的话，如果一个流出错的时候会另一个流关闭不了
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
