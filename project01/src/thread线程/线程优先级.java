package thread线程;

/**
 * @date 2021/4/13 -17:21
 * 优先级高的只是CPU抢占时间较长,处于运行时间较长
 */
public class 线程优先级 {
    public static void main(String[] args) {
//        设置主线程的优先级
        Thread.currentThread().setPriority(1);
//        创建可运行线程类
        int num = Thread.currentThread().getPriority();
        System.out.println(num);
        MyThread07 mt = new MyThread07();
        Thread t = new Thread(mt);
//        设置线程名称
        t.setName("lin");
//        启动线程，开辟栈空间
        t.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + "---->" + i);
        }
    }
}

class MyThread07 implements Runnable {
    @Override

    public void run() {
//        设置支线程的优先级为10
        Thread.currentThread().setPriority(10);
        int num = Thread.currentThread().getPriority();
        System.out.println(num);
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + "---->" + i);
        }
    }
}
