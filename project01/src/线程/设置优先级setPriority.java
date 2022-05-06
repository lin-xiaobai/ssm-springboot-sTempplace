package 线程;

/**
 * @date 2021/3/25 -11:33
 */
public class 设置优先级setPriority extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            System.out.println(Thread.currentThread().getName() + "sssss" + i);
//            try {
//                Thread.sleep(200);
//            }catch (InterruptedException p){
//                p.printStackTrace();
//            }

        }

    }
}
