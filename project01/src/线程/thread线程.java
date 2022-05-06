package 线程;

/**
 * @date 2021/3/25 -10:04
 */
public class thread线程 extends Thread {

    //    重写run方法
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
//            获取线程的id和名字
            System.out.println("线程id" + this.getId() + "线程名称：" + this.getName() + "子线程-----");
        }
    }
}
