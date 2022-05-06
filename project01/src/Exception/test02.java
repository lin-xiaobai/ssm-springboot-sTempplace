package Exception;

/**
 * @date 2021/3/21 -23:21
 */
public class test02 {
    public static void main(String[] args) throws ClassNotFoundException {
//        main方法中调用dosome方法
//         在调用dosome()方法的时候必须对这种异常进行预先的处理
//        如果不处理，编译器就报错
        dosome();

    }

    //定义一个静态方法并且抛出异常
//    dosome方法在方法声明的位置上使用throws ClassNotFoundException
//        这个代码表示dosome()方法在执行过程中，有可能出现ClassNotFoundException
//        这个异常叫做类找不到异常，这个异常的父类是Exception
//    所以这个异常是编译时异常（所有的异常都是在程序时发生的）
    public static void dosome() throws ClassNotFoundException {
        System.out.println("dosome");
    }
}

