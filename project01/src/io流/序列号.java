package io流;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * @date 2021/3/24 -17:36
 * 序列化必须要实现Serializable接口
 * 对象输出（写）流
 */
public class 序列号 {
    public static void main(String[] args) throws Exception {
//        创建字节输出流（实例化）
//        fos为节点流
        FileOutputStream fos = new FileOutputStream("e:\\stu.bin");
//       参数为节点流
        ObjectOutputStream oos = new ObjectOutputStream(fos);
//        创建序列化对象student类
        student zhangsan = new student("张三", 14);
        student lisi = new student("李两", 10);
//        使用集合进行写入数据
        ArrayList<student> list = new ArrayList<>();
        list.add(zhangsan);
        list.add(lisi);
        oos.writeObject(list);
//       oos.writeObject(zhangsan);
//       刷新
        oos.flush();
//       关闭(如果没有flush方法，会调用flush方法）
        oos.close();
        System.out.println("序列化成功");
    }
}
