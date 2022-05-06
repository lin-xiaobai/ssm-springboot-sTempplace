package 线程;

/**
 * @date 2021/3/25 -11:23
 * join线程加入，提前先执行完线程,需要在线程启动前(进入运行状态）
 */
public class joinTest {
    public static void main(String[] args) {
//        创建对象
        join j1 = new join();
        j1.start();
//        参数为对象引用
        try {
            j1.join();
        } catch (InterruptedException i) {
//            打印堆栈异常追踪信息
            i.printStackTrace();
        }
        for (int i = 0; i < 20; i++) {
            System.out.println("main-----" + i);
//            线程休眠(进入抢占cpu时间）
            try {
                Thread.sleep(100);
            } catch (InterruptedException p) {
                p.printStackTrace();
            }
        }

    }
}
