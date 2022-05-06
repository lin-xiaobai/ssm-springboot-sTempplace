package 注解Annotation;

/**
 * @date 2021/4/18 -14:37
 * 自定义异常：调用构造父类方法
 * 有参构造方法的传参是string类型
 */
public class MyException extends Exception {
    public MyException() {
    }

    public MyException(String s) {
        super(s);
    }
}
