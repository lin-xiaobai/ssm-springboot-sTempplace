package thread线程;

/**
 * @date 2021/4/12 -16:09
 */
public class 匿名内部类线程 {
    public static void main(String[] args) {
//        创建线程对象，采用匿名内部类方式
//        通过一个没有名字的类，new出来的对象
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("t线程--" + i);
                }
            }
        });
        t1.start();
        String name = t1.getName();
        System.out.println(name + "--------------");
        for (int i = 0; i < 100; i++) {
            System.out.println("main线程--" + i);
        }
    }
}
