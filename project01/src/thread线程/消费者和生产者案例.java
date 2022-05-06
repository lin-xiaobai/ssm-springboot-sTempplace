package thread线程;

/**
 * @date 2021/4/15 -19:47
 */
public class 消费者和生产者案例 {
    public static void main(String[] args) {
        int n = 0;
        Thread t1 = new num1(n);
        Thread t2 = new num2(n);
        t1.setName("奇数");
        t2.setName("偶数");

        t1.start();
        t2.start();
    }
}

class num1 extends Thread {
    private int a;

    public num1(int a) {
        this.a = a;
    }

    @Override
//    奇数
    public void run() {
        Integer i = a;
        while (true) {
            synchronized (i) {
                if (a % 2 == 0) {
                    try {
                        i.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
//                    唤醒偶数线程
                    a++;
                    System.out.println(Thread.currentThread().getName() + "--->>" + a);
                    this.notifyAll();
                }
            }
        }
    }
}

class num2 extends Thread {
    private int a;

    public num2(int a) {
        this.a = a;
    }

    @Override
    public void run() {
        Integer i = a;
        while (true) {
            synchronized (i) {
                if (a % 2 == 1) {
                    try {
                        System.out.println(Thread.currentThread().getName() + "--->>>" + a);
                        i.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    a++;
                    System.out.println(Thread.currentThread().getName() + "--->" + a);
                    this.notifyAll();
                }
            }
        }
    }
}
