package ioReview;

import java.io.*;

/**
 * @date 2021/4/10 -17:54
 */
public class 字节流转换字符流 {
    public static void main(String[] args) throws IOException {
//        创建文件输入字节流
        FileInputStream fis = new FileInputStream("789.TXT");
//        字节流转换字符流
//        fis是节点流，fr是处理流/包装流
        InputStreamReader fr = new InputStreamReader(fis);
//        创建带有缓冲区的字符输入流
//        fr是节点流，br是处理流、包装流
        BufferedReader br = new BufferedReader(fr);
        String s = null;
//        当文件内容为空的时候，会返回null
        while ((s = br.readLine()) != null) {
            System.out.println(s);
        }
//        关闭最外层的流
        if (br != null) {
            br.close();
        }
    }
}
