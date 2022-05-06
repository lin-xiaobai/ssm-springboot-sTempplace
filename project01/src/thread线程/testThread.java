package thread线程;

/**
 * @date 2021/4/12 -16:39
 */
public class testThread {
    public static void main(String[] args) {
//        创建可运行的线程对象
        threadTest tt = new threadTest();
//        创建线程对象，并且调用构造方法传入一个可运行的线程对象
        Thread t1 = new Thread(tt);
//        设置线程的名称
        t1.setName("线程一");
//        启动线程
        t1.start();

//        创建线程二
        Thread t2 = new Thread(new threadTest());
        System.out.println(t2.getName());
        t2.start();
        Thread name = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            System.out.println(name.getName() + "------>" + i);
        }

    }
}

//创建类实现线程runnable
class threadTest implements Runnable {
    @Override

    public void run() {

        for (int i = 0; i < 10; i++) {
            Thread name1 = Thread.currentThread();
            //    获取当前线程名字
            System.out.println(name1.getName() + "-----》" + i);
        }
    }
}