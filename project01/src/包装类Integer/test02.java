package 包装类Integer;

/**
 * @date 2021/3/30 -17:12
 */
public class test02 {
    public static void main(String[] args) {
//        手动装箱
        Integer i = new Integer("123");
//        手动拆箱
        int y = i.intValue();
        System.out.println(y);

    }
}
