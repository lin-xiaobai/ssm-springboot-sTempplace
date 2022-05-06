package thread线程;

/**
 * @date 2021/4/14 -19:54
 */
public class 锁 {
    public static void main(String[] args) {
        mysuo mc = new mysuo();
        mysuo mc1 = new mysuo();
//        共享数据
        Thread t1 = new mythread(mc);
        Thread t2 = new mythread(mc1);
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();


    }
}

class mythread extends Thread {
    mysuo ms;

    public mythread(mysuo ms) {
        this.ms = ms;
    }

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("t1")) {
            ms.dosome();
        }
        if (Thread.currentThread().getName().equals("t2")) {
            ms.doother();
        }
    }
}

class mysuo {
    public synchronized static void dosome() {
        System.out.println("dosome begin");
        try {
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("dosome over");
    }

    public void doother() {
        System.out.println("doother begin");
        System.out.println("doother over");
    }
}