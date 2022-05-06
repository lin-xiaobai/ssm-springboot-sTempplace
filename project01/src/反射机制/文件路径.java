package 反射机制;

/**
 * @date 2021/4/16 -10:41
 * 怎么获取一个文件的绝对路径。以下方法是通用的，但前提是：文件需要在类路径下，才能用这种方式。
 * 什么是类路径下：在src文件下的
 */
public class 文件路径 {
    public static void main(String[] args) throws Exception {
//        这种方式的缺点是：移植性差，在idea中默认的当前路径是project的根
//        离开了idea，换到了其他操作系统，可能当前路径就不是project的根了，这时这个路径就无效了
//        FileInputStream fis=new FileInputStream("789.TXT");

//        解释：
//        Thread.currentThread()当前线程对象.
//        getContextClassLoader()是线程对象的方法，可以获取到当前线程的类加载器对象
//        getResource()[获取资源] 这时类加载器对象的方法，当前线程的类加载器默认从类的根目录下加载资源
        String path = Thread.currentThread().getContextClassLoader().getResource("test03.class").getPath();
//        这种方式获取文件绝对路径是通用的
        System.out.println(path);

//        获取kkk1.TXT文件的绝对路径（从类的根目录下作为起点开始）
        String path1 = Thread.currentThread().getContextClassLoader().getResource("kkk1.TXT").getPath();
        System.out.println(path1);

    }
}
