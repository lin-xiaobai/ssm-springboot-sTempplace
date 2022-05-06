package thread线程;

/**
 * @date 2021/4/14 -20:17
 */
public class deadLock {
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();
        Thread t1 = new thread(o1, o2);
        Thread t2 = new thread2(o1, o2);
        t1.start();
        t2.start();
    }

}

class thread extends Thread {
    Object o1;
    Object o2;

    public thread(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    @Override
    public void run() {
        synchronized (o1) {
            try {
                System.out.println("锁了");
                Thread.sleep(100 * 12);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o2) {

            }


        }
    }
}

class thread2 extends Thread {
    Object o1;
    Object o2;

    public thread2(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    @Override
    public void run() {
        synchronized (o2) {
            synchronized (o1) {
            }
        }
    }
}
