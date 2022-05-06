package thread线程;

/**
 * @date 2021/4/13 -17:32
 * 暂停当前正在执行的线程对象，并执行其他线程
 */
public class 线程让位 {
    public static void main(String[] args) {
        Thread t = new Thread(new MyThread08());
        t.setName("小明");
        t.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + "---->" + i);
        }
    }
}

class MyThread08 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
//            每10个让给其他线程
            if (i % 100 == 0) {
                Thread.yield();
            }
            System.out.println(Thread.currentThread().getName() + "---->" + i);
        }
    }
}