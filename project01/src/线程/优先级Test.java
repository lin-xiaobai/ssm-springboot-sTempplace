package 线程;

/**
 * @date 2021/3/25 -11:36
 */
public class 优先级Test {
    public static void main(String[] args) {
        //    创建对象
        设置优先级setPriority s1 = new 设置优先级setPriority();
        s1.setName("p1");
        设置优先级setPriority s2 = new 设置优先级setPriority();
        s2.setName("p2");
        设置优先级setPriority s3 = new 设置优先级setPriority();
        s3.setName("p3");
//        设置优先级别（1-10）,默认为5
        s1.setPriority(1);
        s3.setPriority(10);
//        启动线程
        s1.start();
        s2.start();
        s3.start();
    }

}
