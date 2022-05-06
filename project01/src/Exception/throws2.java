package Exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @date 2021/3/22 -15:53
 * <p>
 * 异常处理机制的作用就是增强程序的健壮性。
 * 怎么做到增强健壮性？
 * 异常发生了也不影响程序的执行。
 */

public class throws2 {
    //    一般main方法中的异常建议使用try..catch进行捕捉
//    采用抛出异常方法。
//    public static void main(String[] args) throws  FileNotFoundException {
    public static void main(String[] args) {
        System.out.println("main开始");
//    采用捕捉异常方法
        try {
            m1();
//            以上代码出现异常，直接进入catch语句块执行。
            System.out.println("m1方法执行");
        } catch (FileNotFoundException f) {//catch后面的是一个方法的形参
//            这个分支中可以使用f引用，f引用中保存的内存地址
//            是在那个new出来异常对象的内存地址
//            catch是捕捉异常之后走的分支
            System.out.println("文件找不到");
//            打印输出f引用的内存地址
            System.out.println(f);
        }
//        在捕捉异常后的后面代码可以执行
        System.out.println("main over");
    }

    public static void m1() throws FileNotFoundException {
        System.out.println("m1 begin");
        m2();
//        以上代码出现异常，这里是无法执行的
        System.out.println("m1 over");
    }

    //抛别的异常无法处理该异常
//    Exception包括所有的异常，所以它可以直接抛出
//    throws后面也可以写多个异常，可以使用逗号隔开
    private static void m2() throws FileNotFoundException {
        System.out.println("m2 begin");
        m3();
        System.out.println("m2 over");
    }

    private static void m3() throws FileNotFoundException {
//        编译错误的原因：
//        1.这里调用了一个构造方法： FileInputStream(String name）
//        2.这个构造方法的声明位置上有：throws  FileNotFoundException
//        3.通过类的继承机构可以看到：FileNotFoundException的父类是IOException的
//        ,IOException的父类是Exception的
//        最终得知，FileNotFoundException是编译时异常

//        采用第一种方式：在方法声明的位置上使用throws继续上抛
//        FileInputStream类是创建一个输入流对象，该流指向一个文件
        new FileInputStream("E:\\1232.TXT");
    }
}
