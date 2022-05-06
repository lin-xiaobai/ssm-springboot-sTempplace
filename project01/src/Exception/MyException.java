package Exception;

/**
 * @date 2021/4/1 -21:40
 * 自定义异常
 * 1.继承编译时异常和运行时异常
 * 2.定义一个无参和有参的构造方法
 * 3.有参的构造方法的传参为string类型的
 */
public class MyException extends Exception {
    public MyException() {
        super();
    }

    public MyException(String s) {
//        super:调用父类的构造方法
        super(s);
    }
}
