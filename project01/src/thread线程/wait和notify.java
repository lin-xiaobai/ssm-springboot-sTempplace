package thread线程;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 2021/4/15 -19:17
 */
public class wait和notify {
    public static void main(String[] args) {
        List list = new ArrayList();
        Thread t1 = new Thread(new product(list));
        Thread t2 = new Thread(new comteor(list));
        t1.setName("生产者");
        t2.setName("消费者");
        t1.start();
        t2.start();
    }
}

//生产者，生成一个
class product implements Runnable {
    //    共享数据
    private List list;

    public product(List list) {
        this.list = list;
    }

    @Override
    public void run() {
//        一直生产（使用死循环来模拟一直生产)
        while (true) {
//        因为list里面有一个元素了，所以得让消费者进行消费
//        给仓库对象加锁
            synchronized (list) {
                if (list.size() > 0) {//大于0，表示仓库中已经有一个元素了
                    try {
//                等待，让当前线程进入等待状态，并且会释放之前占有的对象的锁
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
//        程序到这里表示list仓库里面是空，可以生成
                Object obj = new Object();
                list.add(obj);
                System.out.println(Thread.currentThread().getName() + "--->" + obj);
//        唤醒消费者线程
                list.notifyAll();
            }
        }
    }
}

//消费者，消费一个
class comteor implements Runnable {
    //    共享数据
    private List list;

    public comteor(List list) {
        this.list = list;
    }

    @Override
    public void run() {
//        一直消费（使用死循环来模拟一直消费)
        while (true) {
//            如果list集合中的元素为0个，则让当前线程进入等待，并且会释放之前占有的对象的锁
//        给仓库对象加锁
            synchronized (list) {
                if (list.size() == 0) {
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

//        程序到这里表示有list中有一个元素了，需要进行消费
                Object o = list.remove(0);
                System.out.println(Thread.currentThread().getName() + "---->" + o);
//        唤醒线程
                list.notifyAll();
            }
        }
    }
}