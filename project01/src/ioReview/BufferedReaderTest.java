package ioReview;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @date 2021/4/10 -17:39
 * 1.带有缓冲区的字符输入流
 * 2.使用这个流的时候不需要自定义char数组，或者说不需要自定义byte数组。自带缓冲
 */
public class BufferedReaderTest {
    public static void main(String[] args) throws IOException {
//        定义一个字符输入流
        FileReader fr = new FileReader("info.TXT");

//        定义一个带有缓冲区的字符输入流
//        当一个流的构造方法中需要一个流的时候，这个被传进来的流叫做“节点流”。
//        外部负责包装的这个流，叫做：包装流，还有一个名叫做：处理流。

//        FileReader就是一个节点流，BufferedReader就是包装流/处理流
        BufferedReader br = new BufferedReader(fr);

        String s = null;
//        输出一行
        while ((s = br.readLine()) != null) {
            System.out.println(s);

        }
        if (br != null) {
//          包装流：只需要关闭最外层流就行，里面的节点流会自动关闭
            br.close();
        }


    }
}
