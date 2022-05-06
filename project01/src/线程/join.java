package 线程;

/**
 * @date 2021/3/25 -11:20
 */
//继承thread类
public class join extends Thread {
//    重写run方法

    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            System.out.println("子线程。。。。。。" + i);
//            添加线程休息,参数为毫秒
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
