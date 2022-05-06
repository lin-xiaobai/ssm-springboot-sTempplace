package thread线程;

/**
 * @date 2021/4/12 -23:26
 * sleep方法是让当前方法进入休眠状态
 */
public class 终断sleep方法 {
    public static void main(String[] args) {
//        创建可运行线程对象
        Thread t = new Thread(new MyThread());

        t.setName("线程1号");
        t.start();
//        让主线程休眠5秒
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        终止支线程的休眠时间
//        原理是利用sleep方法中的异常处理机制
        t.interrupt();

    }
}

//创建一个线程类实现一个线程接口
class MyThread implements Runnable {

    @Override
//    重写run方法
//    只能捕捉异常，因为子类异常不能比父类异常多，只能更少
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + "支线程启动");
//            让线程进入阻塞状态（休眠）
            Thread.sleep(1000 * 60 * 60 * 24);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "over");
    }
}