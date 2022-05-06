package thread线程;

/**
 * @date 2021/4/13 -17:41
 */
public class 合并线程 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyThread09());
        t1.setName("tt");

        System.out.println(Thread.currentThread().getName() + "开始");
//        合并线程
        t1.start();

        try {
//            t1合并到当前现场
            t1.join();//让main方法进入阻塞状态，直到支线程执行结束，才继续当前线程的执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "结束");
    }
}

class MyThread09 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "---" + i);
        }
    }
}