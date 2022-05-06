package 线程;

/**
 * @date 2021/3/25 -10:32
 */
public class 设置名字线程Test {
    public static void main(String[] args) {
//        创建线程1对象
        设置线程名称 t1 = new 设置线程名称("线程1");
        t1.start();
//        创建线程2对象
        设置线程名称 t2 = new 设置线程名称("线程2");
        t2.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("主线程名称" + Thread.currentThread().getName() + "id" + Thread.currentThread().getId() + "主线程--" + i);
        }


    }
}
