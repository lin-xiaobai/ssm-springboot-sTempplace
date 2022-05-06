package Exception;

/**
 * @date 2021/4/1 -21:43
 */
public class MyExceptionText01 {
    //    创建定义异常对象（只是new一个自定义对象，并没有手动抛出异常（throw）
    public static void main(String[] args) {
//    传参为异常报错信息
        MyException me = new MyException("自定义异常");
//    打印异常的简单描述信息
        String s = me.getMessage();
        System.out.println(s);
//    打印异常的堆栈追踪信息
        me.printStackTrace();
    }
}
