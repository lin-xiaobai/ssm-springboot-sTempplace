package 包装类Integer;

/**
 * @date 2021/3/31 -19:07
 */
public class int和integer和String之间互转 {
    public static void main(String[] args) {
//        int----->String
        int k = 100;
        String num = k + "";

//        String --->int
        String s = "123";
        int i = Integer.parseInt(s);
        System.out.println(i);

//        int--->Integer
        Integer z = 100;
//        Integer--->int
        int y = z;

//        Integer--->String
        Integer z1 = 100;
        String s1 = String.valueOf(z1);
        System.out.println(s1);

//        String---->Integer
        String s2 = "123";
        Integer s3 = Integer.valueOf(s2);
        System.out.println(s3);
    }
}
