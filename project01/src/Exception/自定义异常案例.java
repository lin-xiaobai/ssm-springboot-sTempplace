package Exception;

/**
 * @date 2021/4/1 -21:58
 * 定义一个方法，使用手动抛出异常（抛给调用）
 * 使用捕捉的方式
 */
public class 自定义异常案例 {
    public static void main(String[] args) {
        int num1 = 10;
        try {
            sum(num1);
            System.out.println("您好");
        } catch (自定义异常 e) {
            e.printStackTrace();
        } finally {
            System.out.println("您好吗？");
        }


    }

    public static void sum(int sum) throws 自定义异常 {
        if (10 == sum) {
//            手动抛出异常
            throw new 自定义异常("这个是自定义异常");
        }
    }
}
