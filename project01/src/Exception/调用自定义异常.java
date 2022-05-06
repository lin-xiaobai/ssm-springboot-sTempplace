package Exception;

/**
 * @date 2021/3/22 -20:21
 */
public class 调用自定义异常 {
    public static void main(String[] args) {
        自定义异常 s1 = new 自定义异常("自定义异常");
//        打印堆栈异常追踪信息
//        s1.printStackTrace();
//        打印简单的异常信息
//        s1.getMessage();这个创建的是String类型的引用（对象的内存地址)
        System.out.println(s1.getMessage());
    }
}
