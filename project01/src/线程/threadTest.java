package 线程;

/**
 * @date 2021/3/25 -10:18
 */
public class threadTest {
    public static void main(String[] args) {
//        创建线程对象
        thread线程 t1 = new thread线程();
//        启动线程
        t1.start();
//        创建多个线程
        thread线程 t2 = new thread线程();
//        启动线程t2
        t2.start();
//        主线程
        for (int i = 0; i < 100; i++) {
            System.out.println("主线程的id" + Thread.currentThread().getId() + "主线程的名称" + Thread.currentThread().getName() + "主线程-----" + i);
        }
    }
}
