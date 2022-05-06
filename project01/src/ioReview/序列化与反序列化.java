package ioReview;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @date 2021/4/11 -12:45
 * 序列化：Serialize
 * java对象存储到文件中。将java对象的状态保存下来的过程。
 * 反序列化：DeSerialize
 * 将硬盘上的数据重新恢复到内存当中，恢复成java对象
 * Serializable接口只是一个标志接口：
 * public interface  Serializable{}
 * <p>
 * 这个接口当中没有代码。
 * 它起到了什么作用？
 * 起到标识的作用，标志的作用，java虚拟机看到这个类实现了这个接口，可能会对这个类进行特殊待遇。
 * Serializable这个标志接口是给java虚拟机参考的，java虚拟机看到这个接口之后，会为该类自动生成一个序列化版本号。
 * transient关键字表示游离的，不参与序列化。
 */
public class 序列化与反序列化 {
    public static void main(String[] args) throws Exception {
//        创建对象
        studend s1 = new studend(123, "xiaoming");
        studend s2 = new studend(123, "xiaoming");
//        创建对象输出流
        ObjectOutputStream oop = new ObjectOutputStream(new FileOutputStream("able"));
        oop.writeObject(s1);
        oop.writeObject(s2);

        oop.flush();
        oop.close();
    }

}

//实现序列化接口（标志接口）
class studend implements Serializable {
    transient int no;
    String name;

    public studend(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "studend{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}