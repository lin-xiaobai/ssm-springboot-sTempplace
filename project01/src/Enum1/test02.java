package Enum1;

/**
 * @date 2021/3/21 -19:30
 */
public class test02 {
    public static void main(String[] args) {
//        调用定义的枚举
        yes y = div(2, 1);
        System.out.println(y);
        yes y2 = div(2, 2);
        System.out.println(y2);
        yes y3 = div(1, 1);
        System.out.println(y3);

    }

    //    返回的类型多个结果使用枚举
    public static yes div(int a, int b) {
        if (a * b == 1) {
            return yes.YES;
        }
        if (a * b == 2) {
            return yes.NO;
        }
        if (a * b == 3) {
            return yes.YESS;
        }

        return yes.NOO;
    }

//    定义一个枚举类型，编译后也是一个class文件，值是常量

    enum yes {
        YES, NO, YESS, NOO;
    }
}



