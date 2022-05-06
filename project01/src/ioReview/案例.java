package ioReview;

import java.io.*;

/**
 * @date 2021/4/10 -20:24
 */
public class 案例 {
    public static void main(String[] args) {
//        创建输入输出流
        FileOutputStream fos = null;
        FileInputStream fis = null;
        try {
            fos = new FileOutputStream("e:\\name.TXT");
            fis = new FileInputStream("e:\\name.TXT");
            byte[] bytes = new byte[]{97, 98, 99, 100};
            byte[] b = new byte[10];
            fos.write(bytes);
            fos.flush();
            int readCount = 0;
            while ((readCount = fis.read(b)) != -1) {
                System.out.println(new String(b, 0, readCount));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        File f = new File("e:\\name.TXT");
        System.out.println(f.exists());
        if (f.exists()) {
            System.out.println("是一个目录吗：" + f.isDirectory());
        }
        if (f.exists()) {
            System.out.println("是一个文件" + f.isFile());
            System.out.println("绝对路径是" + f.getAbsolutePath());
        }


    }
}
