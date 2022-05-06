package 线程;

/**
 * @date 2021/3/25 -10:44
 */
public class 匿名内部类runable {
    public static void main(String[] args) {
//        创建对象，使用匿名内部类的方式
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("子线程" + i);
                }
            }
        };
        Thread t1 = new Thread(runnable, "子线程1");
        t1.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("主线程" + i);
        }


    }

}
