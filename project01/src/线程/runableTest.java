package 线程;

/**
 * @date 2021/3/25 -10:39
 */
public class runableTest {
    public static void main(String[] args) {
//        创建对象,表示线程要执行的功能
        runnable r1 = new runnable();
//        创建线程对象
        Thread t1 = new Thread(r1, "线程1");
        t1.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("主线程" + i);
        }
    }
}
