package 线程;

/**
 * @date 2021/3/25 -10:27
 */
//继承线程类
public class 设置线程名称 extends Thread {
    //    无参，有参
    public 设置线程名称() {
    }

    public 设置线程名称(String name) {
//        调用父类的有参构造方法进行改写线程名字
        super(name);
    }

    //    重写run方法
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("线程id" + Thread.currentThread().getId() + "线程名字" + Thread.currentThread().getName() + "子线程" + i);
        }
    }
}
