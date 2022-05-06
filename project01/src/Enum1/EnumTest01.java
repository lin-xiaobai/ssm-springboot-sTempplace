package Enum1;

/**
 * @date 2021/3/21 -19:01
 */
public class EnumTest01 {
    public static void main(String[] args) {
        test suncees = divide(12, 0);
        System.out.println(suncees == test.SUCCESS ? "计算成功" : "计算失败");
        test sunceess = divide(12, 12);
        System.out.println(sunceess == test.SUCCESS ? "计算成功" : "计算失败");


    }

    public static test divide(int a, int b) {
        try {
//            如果程序到这里没有报出异常，则执行下一步
            int num = a / b;
            return test.SUCCESS;

        } catch (Exception e) {
//            如果程序出现异常则执行这一步
            return test.FAIL;
        }
    }
}


//定义一个枚举
//方法执行有多个结果，而且结果可以列举出来
enum test {
    //    SUCCESS是枚举test类型中的一个值，可以看做是常量
    SUCCESS, FAIL, Num
}
