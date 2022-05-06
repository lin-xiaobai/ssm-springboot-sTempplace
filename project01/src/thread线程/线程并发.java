package thread线程;

/**
 * @date 2021/4/11 -23:21
 * 创建线程
 * 重写run方法
 */
public class 线程并发 {
    public static void main(String[] args) {
//        mai方法，这里代码属于主线程，在主栈中运行
//        创建分支线程对象
        test t1 = new test();
//        启动线程
//        start()方法作用是：启动一个分支线程，在JVM中开辟一个新的栈空间，这段代码任务完成之后，瞬间结束
//        这段代码的任务只是为了开启一个新的栈空间，主要新的空间看出来，start（）方法就结束了。线程启动成功
//        启动成功的线程会自动调用run方法，并且run方法在分支栈的栈底部（压栈）
//        run方法在分支栈的栈底部，main方法在主栈的栈底部。run和main是平级的
        t1.start();
//        这里的代码行数运行在主线程中
        for (int i = 0; i < 100; i++) {
            System.out.println("主要线程---" + i);
        }
    }
}

//线程对象必须重写run方法
class test extends Thread {

    @Override
//    这段程序运行在分支线程中
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("副线程---" + i);
        }
    }
}