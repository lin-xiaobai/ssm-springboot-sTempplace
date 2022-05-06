package thread线程;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @date 2021/4/15 -17:58
 * 实现线程的第三种方式：
 */
public class 实现线程的第三种方式 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        第一步：创建一个“未来任务类”对象
//        传参为一个匿名内部类，返回一个对象
        FutureTask task = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
//               线程执行一个任务，执行之后可能有一个执行结果
                System.out.println("call method begin");
                Thread.sleep(1000 * 10);
                System.out.println("call method over");
                int a = 100;
                int b = 100;
                return a + b;//自动装箱
            }
        });
//        启动线程
//        创建线程对象
//        传参为“未来任务类”对象
        Thread t = new Thread(task);

//        这里是main方法，这是在主线程中。
        t.start();
//        get（）方法的执行会导致“当前线程阻塞
//        获取线程t的返回结果
        task.get();

        System.out.println(task.get());

//        main方法这里的程序想要执行必须迭代get（）方法的结束
//        get（）方法是为了获取另一个线程的执行结果，
//        所以必须得等到另一个线程的执行结束
        System.out.println("hello work");

    }
}
