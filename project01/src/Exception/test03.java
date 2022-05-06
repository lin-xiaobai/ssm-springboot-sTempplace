package Exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @date 2021/3/22 -16:50
 * catch分支上要求类型从小到大，即子类型---->父类型
 * catch分支上的形参可以多个
 * 1.catch后面的小括号中的类型可以是具体的异常类型，也可以是该异常类型的父类型。
 * 2.catch可以写多个异常类。建议catch时候，精确的一个一个处理。这样有利于程序的调试。
 * 在jdk8的新特性：可以在catch分支上的括号添加  （|或）运算符
 */
public class test03 {
    public static void main(String[] args) {
        try {
//         创建输入流
            FileInputStream fis = new FileInputStream("E:\\123.TXT");
//         读文件
            fis.read();
            System.out.println("helow");
        } catch (FileNotFoundException | NullPointerException n) {
            System.out.println("文件路径错误");
        } catch (IOException io) {
            System.out.println("文件读取失败");
        }
    }
}
