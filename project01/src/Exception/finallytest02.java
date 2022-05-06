package Exception;

/**
 * @date 2021/3/22 -19:38
 * finally语句可以和try语句联合使用，但是try不能单独使用
 * finally一定会执行
 */
public class finallytest02 {
    public static void main(String[] args) {
        try {
            System.out.println("hell");
            return;
        } finally {
            System.out.println("nin");
            return;
        }
    }
}
