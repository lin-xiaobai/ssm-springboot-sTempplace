package ioReview;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @date 2021/4/10 -12:42
 * 需要抛出异常
 * 文件字节输出流
 * 当读取的文件末尾会返回-1
 * 空格是32
 * <p>
 * 分析程序的缺点：
 * 一次读取一个字节byte，这样内存和硬盘交互太频繁，基本上时间、资源在交互上面了
 */
public class 字节输入流 {
    public static void main(String[] args) {
        FileInputStream fi = null;
        try {
            fi = new FileInputStream("E:\\789.TXT");
//            while (true){
//                int readData=fi.read();
//
////                当readData里面的内容读取完毕后，会返回一个-1的int类型
//                if (readData==-1){
//                    break;
//                }
//            改良
            int readData;
//            当readDate不等于-1时
            while ((readData = fi.read()) != -1) {
                System.out.println(readData);
            }

//                转换为string类型
//                String s=String.valueOf(readData);
//                System.out.println(s+1);
////                强转为char
//                char b= (char) readData;
//                System.out.println(readData);
//                System.out.println(b);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
//            读取文件
        } finally {
            if (fi != null) {
//                关闭流
                try {
                    fi.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
