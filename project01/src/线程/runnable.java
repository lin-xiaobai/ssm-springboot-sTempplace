package 线程;

/**
 * @date 2021/3/25 -10:37
 */
//需要实现接口
public class runnable implements Runnable {
    //    必须写run方法
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("子线程" + Thread.currentThread().getId() + Thread.currentThread().getName() + "-----" + i);
        }
    }
}
