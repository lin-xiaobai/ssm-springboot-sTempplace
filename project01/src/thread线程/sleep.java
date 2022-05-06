package thread线程;

/**
 * @date 2021/4/12 -23:04
 */
public class sleep {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            try {
//                主线程每循环一次休眠1秒
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
