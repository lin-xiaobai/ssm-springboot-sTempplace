package ioReview;

import java.io.DataInputStream;
import java.io.FileInputStream;

/**
 * @date 2021/4/10 -18:32
 * DataInputStream：数据字节输入流
 * DataOutputStream写的文件，只能使用DataInputStream去读。并且读的时候需要提前知道写入的顺序。
 * <p>
 * 读的顺序需要和写的顺序一致，才能正常取出
 */
public class 读取数据字节输入流 {
    public static void main(String[] args) throws Exception {
        DataInputStream dis = new DataInputStream(new FileInputStream("data"));
        dis.readByte();
        dis.readShort();
        int num = dis.readInt();
        dis.readLong();
        dis.readFloat();
        dis.readDouble();
        dis.readBoolean();
        char c = dis.readChar();
        System.out.println(num + 1);
        System.out.println(c);

        dis.close();
    }
}
