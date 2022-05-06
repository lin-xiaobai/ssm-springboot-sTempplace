package 线程;

/**
 * @date 2021/3/25 -11:48
 * 守护线程为后台线程
 * 前台线程执行完毕后台线程也随着结束
 * 默认都是前台线程
 */
public class 守护线程Test {
    public static void main(String[] args) {
//        main默认为前台线程
        守护线程Deamon d1 = new 守护线程Deamon();
        d1.setName("后台线程");
//        设置为后台线程
        d1.setDaemon(true);
        d1.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("主线程---" + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException c) {
                c.printStackTrace();
            }
        }
    }
}
