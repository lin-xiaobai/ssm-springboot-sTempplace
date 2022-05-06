package ioReview;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @date 2021/4/10 -18:24
 * DataOutputStream：数据字节输出流
 * 这个流将数据连同数据的类型一并写入文件。
 * 不是普通文本文档
 */
public class 数据字节输出流 {
    public static void main(String[] args) throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("data"));
        byte b = 1;
        short s = 1;
        int i = 2;
        long l = 1L;
        float f = 10.0f;
        double d = 3.14;
        boolean sex = true;
        char c = 'a';

        dos.writeByte(b);
        dos.writeShort(s);
        dos.writeInt(i);
        dos.writeLong(l);
        dos.writeFloat(f);
        dos.writeDouble(d);
        dos.writeBoolean(sex);
        dos.writeChar(c);

        dos.flush();
        dos.close();
    }

}
