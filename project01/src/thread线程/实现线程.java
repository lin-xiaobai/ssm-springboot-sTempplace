package thread线程;

/**
 * @date 2021/4/12 -15:54
 * 编写一个类，直接实现java.lang.Runnable接口,实现run方法
 */
public class 实现线程 {

    public static void main(String[] args) {
        //    创建一个可运行的对象
        MyRunnable mr = new MyRunnable();
//    将可运行的对象封装成一个线程对象，支线程
        Thread t1 = new Thread(mr);
//    启动线程，这个方法的作用是开辟一个栈，开完就结束
        t1.start();
//    主线程运行
        for (int i = 0; i < 100; i++) {
            System.out.println("主线程" + i);
        }
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("子线程" + i);
        }
    }
}
