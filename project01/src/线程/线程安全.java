package 线程;

import java.util.Arrays;

/**
 * @date 2021/3/25 -12:02
 * 指的是在线程1未完成将数据输入时，cup时间长到了，
 * 该下一个线程2了，此时线程2将数据写入到线程1
 * 解决方式：使用同步代码块（等同于加锁）
 * 加锁的原理：加锁的代码先执行，再执行别的
 */
public class 线程安全 {
    //    存储角标
    private static int index = 0;

    public static void main(String[] args) throws Exception {
//        定义一个数组和数组下标号
        String[] n = new String[5];
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
//                同步代码块
                synchronized (n) {
                    n[index] = "helo";
                    index++;
                }
            }
        };
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                synchronized (n) {
                    n[index] = "work";
                    index++;
                }
            }
        };
//        创建线程
        Thread t1 = new Thread(r1, "a");
        Thread t2 = new Thread(r2, "b");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(Arrays.toString(n));
        for (int i = 0; i < 10; i++) {
            System.out.println("main0" + i);
        }
    }
}
