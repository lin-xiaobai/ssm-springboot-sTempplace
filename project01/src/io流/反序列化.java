package io流;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 * @date 2021/3/24 -17:46
 * 读取重构对象
 * 只能读取一次
 */
public class 反序列化 {
    public static void main(String[] args) throws Exception {
//        创建字节输入流（实例化）fos为节点流
        FileInputStream fis = new FileInputStream("e:\\stu.bin");
//        创建对象反序列化，传入的参数为节点流
        ObjectInputStream ois = new ObjectInputStream(fis);
//        方法传来的是object类，将他强转
//        student zhangsan=(student)ois.readObject();
//        使用集合
        ArrayList<student> list = (ArrayList<student>) ois.readObject();
//        关闭流
        ois.close();
        System.out.println("执行完毕");
//        调用student中的重写toString方法将他打印
        System.out.println(list.toString());


    }
}
