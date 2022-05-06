package Exception;

/**
 * @date 2021/3/22 -18:29
 * 异常对象的两个重要方法：
 * 获取异常简单的描述信息
 * String msg=exception.getMessage
 * <p>
 * 打印异常追踪的堆栈信息：
 * java后台打印 打印异常堆栈信息的时候，采用了异步线程的方式打印的
 * exception.printStackTrace();
 * <p>
 * <p>
 * throw表示手动抛出
 */
public class getMessage_printStackTrace {
    public static void main(String[] args) {
//        new一个异常对象，但是没有将异常对象抛出throw，
//        JVM会认为这个只是一个普通的方法
        NullPointerException e = new NullPointerException("空指针异常");
//        获取异常简单描述信息：这个信息实际上就是构造方法上面的String参数
        String msg = e.getMessage();
        System.out.println(msg);

//        打印异常堆栈信息
//        java后台打印 打印异常堆栈信息的时候，采用了异步线程的方式打印的
        e.printStackTrace();
    }
}
