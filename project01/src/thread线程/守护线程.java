package thread线程;

/**
 * @date 2021/4/14 -21:09
 */
public class 守护线程 {
    public static void main(String[] args) {
        Thread t = new shouhu();
        t.setName("t1");
//       在线程启动前，设置t线程为守护线程
        t.setDaemon(true);
        t.start();
//        主线程是用户线程
        for (int i = 0; i < 10; i++) {
            try {
//                即使该线程是死循环，但由于该线程是守护者，当用户线程结束后，守护线程也会结束
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "--->" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class shouhu extends Thread {
    int i = 0;

    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "--->" + (++i));
        }
    }
}
