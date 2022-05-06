package ioReview;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * @date 2021/4/11 -12:52
 * 将对象文件从硬盘上读取到内存上
 */
public class 反序列化 {
    public static void main(String[] args) throws Exception {
//        创建对象输入流
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("able"));


//      反序列化，读
        Object obj = ois.readObject();
        //序列化过来的是一个对象。
        System.out.println(obj.toString());
        ois.close();
    }
}
