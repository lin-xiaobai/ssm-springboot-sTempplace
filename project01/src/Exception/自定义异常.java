package Exception;

/**
 * @date 2021/3/22 -20:16
 * 自定义异常：
 * 定义一个类继承Exception(编译时异常)或者RuntimeException（运行时异常）
 * 然后在创建有参和无参构造方法
 */
//编译时异常
public class 自定义异常 extends Exception {
    public 自定义异常() {

    }

    public 自定义异常(String s) {
//            调用父类中的有参构造方法
        super(s);
    }

}
//定义一个运行时异常
//public class 自定义异常 extends RuntimeException  {
//    public  自定义异常(){
//
//    }
//    public  自定义异常(String s){
////            调用父类中的有参构造方法
//        super(s);
//    }
//
//}

