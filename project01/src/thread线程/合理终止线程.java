package thread线程;

/**
 * @date 2021/4/13 -14:41
 * 合理终止线程：
 * 在可运行的类中打一个标记，
 * 使用if判断是否终止线程
 */
public class 合理终止线程 {
    public static void main(String[] args) {
//        创建可运行的类
        Myrunnable4 mr4 = new Myrunnable4();
//        创建线程类
        Thread t1 = new Thread(mr4);
//        修改线程名字
        t1.setName("tt");
//        启动线程，进行创建栈空间
        t1.start();
//        主线程休眠5秒后终止支线程
        try {
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        终止支线程
//        原理：让支线程里的标记修改为false
        mr4.flae = false;
        System.out.println(Thread.currentThread().getName() + "终止");
    }
}

//创建一个可运行的线程，实现类
class Myrunnable4 implements Runnable {
    //    标记
    boolean flae = true;

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            if (flae) {
                System.out.println(Thread.currentThread().getName() + "--》" + i);
//                每循环一次休眠1秒
                try {
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } else {
//            可以在return前进行保存内容
//            终止线程（终止方法执行）
                return;
            }
        }


    }
}