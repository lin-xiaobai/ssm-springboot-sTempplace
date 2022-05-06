package Exception;

/**
 * @date 2021/4/1 -15:41
 */
public class test04 {
    public static void main(String[] args) {
        NullPointerException bpe = new NullPointerException("空指针异常");
        System.out.println(bpe);
        int sum = 123;
        String sum1 = String.valueOf(sum);
        System.out.println(sum1 + 1);
        int i = Integer.valueOf("1234");
        System.out.println(i + 1);

    }
}
